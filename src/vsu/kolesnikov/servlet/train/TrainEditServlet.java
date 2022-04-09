package vsu.kolesnikov.servlet.train;

import vsu.kolesnikov.dao.TrainStorage;
import vsu.kolesnikov.service.TrainService;
import vsu.kolesnikov.servlet.mappers.TrainRequestExtractor;
import vsu.kolesnikov.сomponents.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = {"/train/edit"})
public class TrainEditServlet extends HttpServlet {
    private TrainService service;
    private TrainRequestExtractor extractor;

    @Override
    public void init() {
        service = new TrainService(new TrainStorage());
        extractor = new TrainRequestExtractor();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        req.setAttribute("train", service.find(id));

        req.getRequestDispatcher("../jsp/trainFormEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Train train = extractor.extract(req);
        service.update(train);
        resp.sendRedirect("/train");
    }
}
