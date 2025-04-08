package ticket.booking.entities;

import java.util.*;

public class Train {
    
    private String trainId;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String,String> stationTimes;
    private List<String>stations;

    public Train(String trainId, String trainNo, List<List<Integer>> seats, Map<String,String>stationTimes,List<String>stations)
    {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seats = seats;
        this.stationTimes = stationTimes;
        this.stations = stations;
    }

    public Train() {}

    public String setTrainId(){
        return trainId;
    }
    public void getTrainId(String trainId){
        this.trainId = trainId;
    }

    public String setTrainNo(){
        return trainNo;
    }
    public void getTrainNo(String trainNo){
        this.trainNo = trainNo;
    }

    public List<List<Integer>> setSeats(){
        return seats;
    }
    public void getSeats(List<List<Integer>>seats){
        this.seats = seats;
    }

    public String getTrainInfo(){
        return String.format("Train ID: %s Train No: %s", trainId, trainNo);
    }
}
