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

@WebServlet(urlPatterns = {"/waypoint/edit"})
public class WaypointEditServlet extends HttpServlet {
    private WaypointService service;
    private WaypointRequestExtractor extractor;

    @Override
    public void init() {
        service = new WaypointService(new WaypointStorage());
        extractor = new WaypointRequestExtractor();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        req.setAttribute("waypoint", service.find(id));

        req.getRequestDispatcher("../jsp/waypointFormEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Waypoint waypoint = extractor.extract(req);
        service.update(waypoint);
        resp.sendRedirect("/waypoint");

    }
}
