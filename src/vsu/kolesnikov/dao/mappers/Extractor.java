package vsu.kolesnikov.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Extractor<T> {
    public T extract(ResultSet resultSet) throws SQLException;

    public List<T> multi(ResultSet resultSet) throws SQLException;
}