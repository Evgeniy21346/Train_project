package vsu.kolesnikov.servlet.mappers;

import vsu.kolesnikov.сomponents.Waypoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Time;

public class WaypointRequestExtractor implements RequestExtractor<Waypoint> {
    private static WaypointRequestExtractor extractor;

    public WaypointRequestExtractor() {
    }

    public static WaypointRequestExtractor getInstance() {
        if (extractor == null) {
            extractor = new WaypointRequestExtractor();
        }

        return extractor;
    }

    @Override
    public Waypoint extract(HttpServletRequest req) throws ServletException, UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");

        Waypoint waypoint = new Waypoint();

        String ID = req.getParameter("id");

        if (ID != null) {
            waypoint.setID(Integer.parseInt(ID));
        }

        String station = req.getParameter("station");
        Time arrivalTime = Time.valueOf(req.getParameter("arrivalTime"));
        Time departureTime = Time.valueOf(req.getParameter("departureTime"));

        waypoint.setStation(station);
        waypoint.setArrivalTime(arrivalTime);
        waypoint.setDepartureTime(departureTime);

        return waypoint;
    }
}
