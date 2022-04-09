package vsu.kolesnikov.servlet.waypointTrain;

import vsu.kolesnikov.dao.WaypointTrainStorage;
import vsu.kolesnikov.service.WaypointTrainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/waypointOfTrain/remove")
public class WaypointTrainRemoveServlet extends HttpServlet {
    private WaypointTrainService service;

    @Override
    public void init() {
        service = new WaypointTrainService(new WaypointTrainStorage());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] args = req.getParameterValues("id");

        service.remove(args);
        resp.sendRedirect("/waypointOfTrain");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
