package vsu.kolesnikov.servlet.waypoint;

import vsu.kolesnikov.dao.WaypointStorage;
import vsu.kolesnikov.dao.WaypointTrainStorage;
import vsu.kolesnikov.service.WaypointService;
import vsu.kolesnikov.service.WaypointTrainService;
import vsu.kolesnikov.сomponents.WaypointTrain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(value = "/waypoint/remove")
public class WaypointRemoveServlet extends HttpServlet {
    private WaypointService service;
    private WaypointTrainService waypointTrainService;

    @Override
    public void init() {
        service = new WaypointService(new WaypointStorage());
        waypointTrainService = new WaypointTrainService(new WaypointTrainStorage());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        WaypointTrain waypointTrain = waypointTrainService.findBy(id, "0");

        if(waypointTrain == null){
            service.remove(id);
            resp.sendRedirect("/waypoint");
        } else {
            resp.getOutputStream().write("Entity is used in another table.".getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
