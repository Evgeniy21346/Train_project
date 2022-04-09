package vsu.kolesnikov.servlet.waypointTrain;

import vsu.kolesnikov.dao.TrainStorage;
import vsu.kolesnikov.dao.WaypointStorage;
import vsu.kolesnikov.dao.WaypointTrainStorage;
import vsu.kolesnikov.service.TrainService;
import vsu.kolesnikov.service.WaypointService;
import vsu.kolesnikov.service.WaypointTrainService;
import vsu.kolesnikov.servlet.mappers.WaypointTrainRequestExtractor;
import vsu.kolesnikov.сomponents.WaypointTrain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = {"/waypointOfTrain/add"})
public class WaypointTrainAddServlet extends HttpServlet {
    private WaypointTrainService service;
    private WaypointService waypointService;
    private TrainService trainService;
    private WaypointTrainRequestExtractor extractor;

    @Override
    public void init() {
        waypointService = new WaypointService(new WaypointStorage());
        trainService = new TrainService(new TrainStorage());
        service = new WaypointTrainService(new WaypointTrainStorage());
        extractor = new WaypointTrainRequestExtractor();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WaypointTrain waypointTrain = new WaypointTrain();

        req.setAttribute("waypoints", waypointService.get());
        req.setAttribute("trains", trainService.get());
        req.setAttribute("waypointTrain", waypointTrain);

        req.getRequestDispatcher("../jsp/waypointsOfTrainFormAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        WaypointTrain waypointTrain = extractor.extract(req);
        WaypointTrain find = service.find(String.valueOf(waypointTrain.getID_waypoint().getID()),
                String.valueOf(waypointTrain.getID_train().getID()), String.valueOf(waypointTrain.getNumber()));

        if (find == null) {
            service.add(waypointTrain);
            resp.sendRedirect("/waypointOfTrain");
        } else {
            resp.getOutputStream().write("Primary key violation.".getBytes(StandardCharsets.UTF_8));
        }
    }
}
