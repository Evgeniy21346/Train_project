package vsu.kolesnikov.servlet.train;

import vsu.kolesnikov.dao.TrainStorage;
import vsu.kolesnikov.service.TrainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/train")
public class TrainServlet extends HttpServlet {
    private TrainService service;

    @Override
    public void init() {
        service = new TrainService(new TrainStorage());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("trains", service.get());

        req.getRequestDispatcher("/jsp/trains.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
