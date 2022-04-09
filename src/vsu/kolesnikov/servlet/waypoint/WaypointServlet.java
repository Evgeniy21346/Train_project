package vsu.kolesnikov.servlet.waypoint;

import vsu.kolesnikov.dao.WaypointStorage;
import vsu.kolesnikov.service.WaypointService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/waypoint")
public class WaypointServlet extends HttpServlet {
    private WaypointService service;

    @Override
    public void init() {
        service = new WaypointService(new WaypointStorage());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("waypoints", service.get());

        req.getRequestDispatcher("/jsp/waypoints.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
