
package ticket.booking.entities;

import java.util.*;

public class User {

    private String userId;
    private String name;
    private String password;
    private String hashedPassword;
    private List<Ticket> ticketsBooked;
    
    
    public User(String userId, String name, String password, String hashedPassword, List<Ticket>ticketsBooked)
    {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketsBooked = ticketsBooked;
    }

    public User (){}

    
    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getHashedPassword(){
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }

    public List<Ticket> getTicketsBooked(){
        return ticketsBooked;
    }

    public void setTicketsBooked(List<Ticket>ticketsBooked){
        this.ticketsBooked = ticketsBooked;
    }

    public void printTicket(){

        for(int i=0;i<ticketsBooked.size();i++)
        {
            System.out.println(ticketsBooked.get(i).getTicketInfo());
        }
    }


}
