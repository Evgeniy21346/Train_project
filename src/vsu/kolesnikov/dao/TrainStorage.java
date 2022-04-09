package vsu.kolesnikov.dao;

import vsu.kolesnikov.dao.interfaces.ITrainRepository;
import vsu.kolesnikov.dao.mappers.TrainExtractor;
import vsu.kolesnikov.сomponents.Train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class TrainStorage implements ITrainRepository {
    private final ConnectionManager connectionManager;
    private final TrainExtractor trainExtractor;

    public TrainStorage() {
        connectionManager = ConnectionManager.getInstance();
        trainExtractor = TrainExtractor.getInstance();
    }

    @Override
    public void add(Train obj) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO train(name,route) VALUES (?,?)");
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getRoute());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("name=UNIQUE");
        }
    }

    @Override
    public void remove(Train obj) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM train WHERE ID=?");
            preparedStatement.setInt(1, obj.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Train obj) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE train SET name=?, route=? WHERE ID=?");
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getRoute());
            preparedStatement.setInt(3, obj.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Train find(String arg) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM train WHERE ID=?");
            preparedStatement.setInt(1, Integer.parseInt(arg));
            return trainExtractor.extract(preparedStatement.executeQuery());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Train findByName(String arg) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM train WHERE name=?");
            preparedStatement.setString(1, arg);
            return trainExtractor.extract(preparedStatement.executeQuery());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Train> get() {
        try (Connection connection = connectionManager.getConnection()) {
            Statement statement = connection.createStatement();
            return trainExtractor.multi(statement.executeQuery("SELECT * FROM train ORDER BY ID"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
