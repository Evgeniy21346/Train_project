package vsu.kolesnikov.servlet.mappers;

import vsu.kolesnikov.сomponents.Train;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class TrainRequestExtractor implements RequestExtractor<Train> {
    private static TrainRequestExtractor extractor;

    public TrainRequestExtractor() {
    }

    public static TrainRequestExtractor getInstance() {
        if (extractor == null) {
            extractor = new TrainRequestExtractor();
        }

        return extractor;
    }

    @Override
    public Train extract(HttpServletRequest req) throws ServletException, UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");

        Train train = new Train();

        String ID = req.getParameter("id");

        if (ID != null) {
            train.setID(Integer.parseInt(ID));
        }

        String name = req.getParameter("name");
        String route = req.getParameter("route");

        train.setName(name);
        train.setRoute(route);

        return train;
    }
}
