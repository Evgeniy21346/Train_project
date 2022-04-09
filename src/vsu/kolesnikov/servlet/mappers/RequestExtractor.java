package vsu.kolesnikov.servlet.mappers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public interface RequestExtractor<T> {
    T extract(HttpServletRequest req) throws ServletException, UnsupportedEncodingException;
}
