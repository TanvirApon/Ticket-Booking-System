package ticket.booking.entities;

import java.util.*;

public class Ticket {
    
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private String dateOfTravel;
    private Train train;


    public Ticket(String ticketId, String userId, String source, String destination, String dateOfTravel, Train train){
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
    }

    public Ticket() {}

    public void setTicketId(String ticketId){
        this.ticketId = ticketId;
    }
    public String getTicketId(){
        return ticketId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }
    public String setUserId(){
        return userId;
    }

    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return source;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }
    public String getDestination(){
        return destination;
    }

    public void setDateOfTravel(String dateOfTravel){
        this.dateOfTravel = dateOfTravel;
    }
    public String dateOfTravel(){
        return dateOfTravel;
    }

    public void setTrain(Train train){
        this.train = train;
    }
    public Train getTrain(){
        return train;
    }

    public String getTicketInfo(){
        return String.format("Ticket ID: %s belongs to User %s from %s to %s on %s", ticketId, userId, source, destination, dateOfTravel);
    }

}
