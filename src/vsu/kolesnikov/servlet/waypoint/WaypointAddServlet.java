package vsu.kolesnikov.servlet.waypoint;

import vsu.kolesnikov.dao.WaypointStorage;
import vsu.kolesnikov.service.WaypointService;
import vsu.kolesnikov.servlet.mappers.WaypointRequestExtractor;
import vsu.kolesnikov.сomponents.Waypoint;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = {"/waypoint/add"})
public class WaypointAddServlet extends HttpServlet {
    private WaypointService service;
    private WaypointRequestExtractor extractor;

    @Override
    public void init() {
        service = new WaypointService(new WaypointStorage());
        extractor = new WaypointRequestExtractor();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Waypoint waypoint = new Waypoint();

        req.setAttribute("waypoint", waypoint);

        req.getRequestDispatcher("../jsp/waypointFormAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Waypoint waypoint = extractor.extract(req);
        Waypoint find = service.findBy(waypoint.getStation());

        if (find == null) {
            service.add(waypoint);
            resp.sendRedirect("/waypoint");
        } else {
            resp.getOutputStream().write("The STATION field in the WAYPOINT table must be unique.".getBytes(StandardCharsets.UTF_8));
        }
    }
}
