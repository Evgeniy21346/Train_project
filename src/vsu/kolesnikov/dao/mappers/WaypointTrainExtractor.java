package vsu.kolesnikov.dao.mappers;

import vsu.kolesnikov.dao.TrainStorage;
import vsu.kolesnikov.dao.WaypointStorage;
import vsu.kolesnikov.сomponents.WaypointTrain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaypointTrainExtractor implements Extractor<WaypointTrain>{
    private static WaypointTrainExtractor waypointTrainExtractor;
    public static WaypointStorage waypointStorage;
    public static TrainStorage trainStorage;

    private WaypointTrainExtractor() {

    }

    public static WaypointTrainExtractor getInstance() {
        if (waypointTrainExtractor == null) {
            waypointTrainExtractor = new WaypointTrainExtractor();
            waypointStorage = new WaypointStorage();
            trainStorage = new TrainStorage();
        }
        return waypointTrainExtractor;
    }

    @Override
    public WaypointTrain extract(ResultSet resultSet) throws SQLException {
        WaypointTrain waypointTrain = null;
        if (resultSet.next()) {
            waypointTrain = new WaypointTrain();
            waypointTrain.setID_waypoint(waypointStorage.find(resultSet.getString("ID_waypoint")));
            waypointTrain.setID_train(trainStorage.find(resultSet.getString("ID_train")));
            waypointTrain.setNumber(resultSet.getInt("Number"));
        }
        return waypointTrain;
    }

    @Override
    public List<WaypointTrain> multi(ResultSet resultSet) throws SQLException {
        List<WaypointTrain> list = new ArrayList<>();
        while (resultSet.next()) {
            WaypointTrain waypointTrain = new WaypointTrain();
            waypointTrain.setID_waypoint(waypointStorage.find(resultSet.getString("ID_waypoint")));
            waypointTrain.setID_train(trainStorage.find(resultSet.getString("ID_train")));
            waypointTrain.setNumber(resultSet.getInt("Number"));
            list.add(waypointTrain);
        }
        return list;
    }
}
