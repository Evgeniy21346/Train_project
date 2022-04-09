package vsu.kolesnikov.servlet.train;

import vsu.kolesnikov.dao.TrainStorage;
import vsu.kolesnikov.dao.WaypointTrainStorage;
import vsu.kolesnikov.service.TrainService;
import vsu.kolesnikov.service.WaypointTrainService;
import vsu.kolesnikov.сomponents.WaypointTrain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(value = "/train/remove")
public class TrainRemoveServlet extends HttpServlet {
    private TrainService service;
    private WaypointTrainService waypointTrainService;

    @Override
    public void init() {
        service = new TrainService(new TrainStorage());
        waypointTrainService = new WaypointTrainService(new WaypointTrainStorage());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        WaypointTrain waypointTrain = waypointTrainService.findBy("0", id);

        if(waypointTrain == null){
            service.remove(id);
            resp.sendRedirect("/train");
        } else {
            resp.getOutputStream().write("Entity is used in another table.".getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}