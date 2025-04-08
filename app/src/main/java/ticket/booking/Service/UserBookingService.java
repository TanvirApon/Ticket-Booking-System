package ticket.booking.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Ticker;

import ticket.booking.Util.UserServiceUtil;
import ticket.booking.entities.User;

public class UserBookingService {
    

    private User user;

    private List<User>userList;

    private static ObjectMapper objectmapper = new ObjectMapper();
    private static final String USERS_PATH = "app/src/main/java/ticket/booking/localDb/users.json";

    public UserBookingService(User user1)throws IOException{
        this.user = user1;
        loadUserListFromFile();
    }

     
    public Boolean loginUser(){

        Optional<User> foundUser = userList.stream().filter(user1->{
            
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(),user1.getHashedPassword());
        }).findFirst();

        return foundUser.isPresent();
    }

    public Boolean singUp(User user1){
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } 
        catch (Exception e) {
            return Boolean.FALSE;
        }
    }


    private void saveUserListToFile() throws IOException{
        File userFile = new File(USERS_PATH);
        objectmapper.writeValue(userFile, userList);
    }

    private void loadUserListFromFile()throws IOException{
        File users = new File(USERS_PATH);
        userList = objectmapper.readValue(users, new TypeReference<List<User>>(){});
    }


    public void fetchBooking(){
        Optional<User>userFetched = userList.stream().filter(user1->{
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(),user1.getHashedPassword());
        }).findFirst();

        if(userFetched.isPresent()){
            userFetched.get().printTicket();
        }
    }


    public Boolean cancelBooking(String ticketId){
        Scanner sc = new Scanner(System.in);
        ticketId = sc.next();
        
        if(ticketId == null || ticketId.isEmpty()){
            System.out.println("TicketId not Found\n");
            return Boolean.FALSE;
        }

        String finalTicketId = ticketId;
        boolean removed = user.getTicketsBooked().removeIf(ticket->ticket.getTicketId().equals(finalTicketId));

        if(removed){
            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
            return Boolean.TRUE;
        }
        else{
            System.out.println("No ticket found with ID " + ticketId);
            return Boolean.FALSE;
        }

    }






}
