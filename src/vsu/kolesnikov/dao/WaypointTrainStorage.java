package vsu.kolesnikov.dao;

import vsu.kolesnikov.dao.interfaces.IWaypointTrainRepository;
import vsu.kolesnikov.dao.mappers.WaypointTrainExtractor;
import vsu.kolesnikov.сomponents.WaypointTrain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class WaypointTrainStorage implements IWaypointTrainRepository {
    private final ConnectionManager connectionManager;
    private final WaypointTrainExtractor waypointTrainExtractor;

    public WaypointTrainStorage() {
        connectionManager = ConnectionManager.getInstance();
        waypointTrainExtractor = WaypointTrainExtractor.getInstance();
    }

    @Override
    public void add(WaypointTrain obj) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO waypoint_train(id_waypoint,id_train,number) VALUES (?,?,?)");
            preparedStatement.setInt(1, obj.getID_waypoint().getID());
            preparedStatement.setInt(2, obj.getID_train().getID());
            preparedStatement.setInt(3, obj.getNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(WaypointTrain obj) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM waypoint_train WHERE (id_waypoint=? AND id_train=? AND number=?)");
            preparedStatement.setInt(1, obj.getID_waypoint().getID());
            preparedStatement.setInt(2, obj.getID_train().getID());
            preparedStatement.setInt(3, obj.getNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(WaypointTrain obj) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE waypoint_train SET number=?, WHERE (id_waypoint=? AND id_train=?)");
            preparedStatement.setInt(1, obj.getNumber());
            preparedStatement.setInt(2, obj.getID_waypoint().getID());
            preparedStatement.setInt(3, obj.getID_train().getID());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public WaypointTrain find(String... args) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM waypoint_train WHERE (id_waypoint=? AND id_train=? AND number=?)");
            preparedStatement.setInt(1, Integer.parseInt(args[0]));
            preparedStatement.setInt(2, Integer.parseInt(args[1]));
            preparedStatement.setInt(3, Integer.parseInt(args[2]));
            return waypointTrainExtractor.extract(preparedStatement.executeQuery());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public WaypointTrain findBy(String... args) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM waypoint_train WHERE (id_waypoint=? OR id_train=?)");
            preparedStatement.setInt(1, Integer.parseInt(args[0]));
            preparedStatement.setInt(2, Integer.parseInt(args[1]));
            return waypointTrainExtractor.extract(preparedStatement.executeQuery());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<WaypointTrain> get() {
        try (Connection connection = connectionManager.getConnection()) {
            Statement statement = connection.createStatement();
            return waypointTrainExtractor.multi(statement.executeQuery("SELECT * FROM waypoint_train ORDER BY number"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
