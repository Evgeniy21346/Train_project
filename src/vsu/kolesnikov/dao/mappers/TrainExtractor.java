package vsu.kolesnikov.dao.mappers;

import vsu.kolesnikov.сomponents.Train;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainExtractor implements Extractor<Train> {
    private static TrainExtractor trainExtractor;

    private TrainExtractor() {

    }

    public static TrainExtractor getInstance() {
        if (trainExtractor == null) {
            trainExtractor = new TrainExtractor();
        }
        return trainExtractor;
    }

    @Override
    public Train extract(ResultSet resultSet) throws SQLException {
        Train train = null;
        if (resultSet.next()) {
            train = new Train();
            train.setID(resultSet.getInt("ID"));
            train.setName(resultSet.getString("name"));
            train.setRoute(resultSet.getString("route"));
        }
        return train;
    }

    @Override
    public List<Train> multi(ResultSet resultSet) throws SQLException {
        List<Train> list = new ArrayList<>();
        while (resultSet.next()) {
            Train train = new Train();
            train.setID(resultSet.getInt("ID"));
            train.setName(resultSet.getString("name"));
            train.setRoute(resultSet.getString("route"));
            list.add(train);
        }
        return list;
    }
}
