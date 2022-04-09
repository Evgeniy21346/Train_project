package vsu.kolesnikov.dao;

import vsu.kolesnikov.dao.interfaces.IWaypointRepository;
import vsu.kolesnikov.dao.mappers.WaypointExtractor;
import vsu.kolesnikov.сomponents.Waypoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class WaypointStorage implements IWaypointRepository {
    private final ConnectionManager connectionManager;
    private final WaypointExtractor waypointExtractor;

    public WaypointStorage() {
        connectionManager = ConnectionManager.getInstance();
        waypointExtractor = WaypointExtractor.getInstance();
    }

    @Override
    public void add(Waypoint obj) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO waypoint(station,arrivaltime,departuretime) VALUES (?,?,?)");
            preparedStatement.setString(1, obj.getStation());
            preparedStatement.setTime(2, obj.getArrivalTime());
            preparedStatement.setTime(3, obj.getDepartureTime());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(Waypoint obj) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM waypoint WHERE ID=?");
            preparedStatement.setInt(1, obj.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Waypoint obj) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE waypoint SET station=?, arrivaltime=?, departuretime=? WHERE ID=?");
            preparedStatement.setString(1, obj.getStation());
            preparedStatement.setTime(2, obj.getArrivalTime());
            preparedStatement.setTime(3, obj.getDepartureTime());
            preparedStatement.setInt(4,obj.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Waypoint find(String arg) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM waypoint WHERE ID=?");
            preparedStatement.setInt(1, Integer.parseInt(arg));
            return waypointExtractor.extract(preparedStatement.executeQuery());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Waypoint findByStation(String arg) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM waypoint WHERE station=?");
            preparedStatement.setString(1, arg);
            return waypointExtractor.extract(preparedStatement.executeQuery());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Waypoint> get() {
        try (Connection connection = connectionManager.getConnection()) {
            Statement statement = connection.createStatement();
            return waypointExtractor.multi(statement.executeQuery("SELECT * FROM waypoint ORDER BY ID"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
