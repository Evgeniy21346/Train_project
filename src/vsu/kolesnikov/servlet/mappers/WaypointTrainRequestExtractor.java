package vsu.kolesnikov.servlet.mappers;

import vsu.kolesnikov.dao.TrainStorage;
import vsu.kolesnikov.dao.WaypointStorage;
import vsu.kolesnikov.service.TrainService;
import vsu.kolesnikov.service.WaypointService;
import vsu.kolesnikov.сomponents.Train;
import vsu.kolesnikov.сomponents.Waypoint;
import vsu.kolesnikov.сomponents.WaypointTrain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class WaypointTrainRequestExtractor implements RequestExtractor<WaypointTrain>{
    private static WaypointTrainRequestExtractor extractor;
    private WaypointService waypointService;
    private TrainService trainService;

    public WaypointTrainRequestExtractor() {
        waypointService = new WaypointService(new WaypointStorage());
        trainService = new TrainService(new TrainStorage());
    }

    public static WaypointTrainRequestExtractor getInstance() {
        if (extractor == null) {
            extractor = new WaypointTrainRequestExtractor();
        }

        return extractor;
    }
    @Override
    public WaypointTrain extract(HttpServletRequest req) throws ServletException, UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");

        WaypointTrain waypointTrain = new WaypointTrain();

        String station = req.getParameter("station");
        String name = req.getParameter("name");
        String number = req.getParameter("number");

        Waypoint waypoint = waypointService.findBy(station);
        Train train = trainService.findBy(name);

        waypointTrain.setID_train(train);
        waypointTrain.setID_waypoint(waypoint);
        waypointTrain.setNumber(Integer.parseInt(number));

        return waypointTrain;
    }
}
