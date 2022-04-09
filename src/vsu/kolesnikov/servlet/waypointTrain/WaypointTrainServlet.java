package vsu.kolesnikov.servlet.waypointTrain;

import vsu.kolesnikov.dao.WaypointTrainStorage;
import vsu.kolesnikov.service.WaypointTrainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/waypointOfTrain")
public class WaypointTrainServlet extends HttpServlet {
    private WaypointTrainService service;

    @Override
    public void init() {
        service = new WaypointTrainService(new WaypointTrainStorage());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("waypointsTrain", service.get());

        req.getRequestDispatcher("/jsp/waypointsOfTrains.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
