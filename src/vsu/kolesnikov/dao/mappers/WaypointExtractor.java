package vsu.kolesnikov.dao.mappers;

import vsu.kolesnikov.сomponents.Waypoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaypointExtractor implements Extractor<Waypoint> {
    private static WaypointExtractor waypointExtractor;

    private WaypointExtractor() {

    }

    public static WaypointExtractor getInstance() {
        if (waypointExtractor == null) {
            waypointExtractor = new WaypointExtractor();
        }
        return waypointExtractor;
    }

    @Override
    public Waypoint extract(ResultSet resultSet) throws SQLException {
        Waypoint waypoint = null;
        if (resultSet.next()) {
            waypoint = new Waypoint();
            waypoint.setID(resultSet.getInt("ID"));
            waypoint.setStation(resultSet.getString("station"));
            waypoint.setArrivalTime(resultSet.getTime("arrivaltime"));
            waypoint.setDepartureTime(resultSet.getTime("departuretime"));
        }
        return waypoint;
    }

    @Override
    public List<Waypoint> multi(ResultSet resultSet) throws SQLException {
        List<Waypoint> list = new ArrayList<>();
        while (resultSet.next()) {
            Waypoint waypoint = new Waypoint();
            waypoint.setID(resultSet.getInt("ID"));
            waypoint.setStation(resultSet.getString("station"));
            waypoint.setArrivalTime(resultSet.getTime("arrivaltime"));
            waypoint.setDepartureTime(resultSet.getTime("departuretime"));
            list.add(waypoint);
        }
        return list;
    }
}
