package ticket.booking.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ticket.booking.entities.Train;

public class TrainService {
    private List<Train>trainList;
    private ObjectMapper objectmapper = new ObjectMapper();
    private static final String Train_Db_Path = "app/src/main/java/ticket/booking/localDb/trains.json";


    public TrainService() throws IOException{
        File trains = new File(Train_Db_Path);
        trainList = objectmapper.readValue(trains, new TypeReference<List<Train>>() {});
    }


    public List<Train>searchTrains(String source, String destination){
        return trainList.stream().filter(train->validTrain(train,source,destination)).collect(Collectors.toList());
    }

    private void saveTrainListToFile(){
        try {
            objectmapper.writeValue(new File(Train_Db_Path), trainList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validTrain(Train train, String source, String destination){
        List<String>stationOrder = train.getStations();

        int sourceIndex = stationOrder.indexOf(source.toLowerCase());
        int destinationIndex = stationOrder.indexOf(destination.toLowerCase());

        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }
    
}
