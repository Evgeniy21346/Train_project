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

@WebServlet(urlPatterns = {"/train/add"})
public class TrainAddServlet extends HttpServlet {
    private TrainService service;
    private TrainRequestExtractor extractor;

    @Override
    public void init() {
        service = new TrainService(new TrainStorage());
        extractor = new TrainRequestExtractor();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Train train = new Train();

        req.setAttribute("train", train);

        req.getRequestDispatcher("../jsp/trainFormAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Train train = extractor.extract(req);
        Train find = service.findBy(train.getName());
        if(find==null){
            service.add(train);
            resp.sendRedirect("/train");
        } else {
            resp.getOutputStream().write("The NAME field in the TRAIN table must be unique.".getBytes(StandardCharsets.UTF_8));
        }
    }
}
