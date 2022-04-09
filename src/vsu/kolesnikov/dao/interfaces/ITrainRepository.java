package vsu.kolesnikov.dao.interfaces;

import vsu.kolesnikov.сomponents.Train;

import java.util.Collection;

public interface ITrainRepository {
    public void add(Train obj);

    public void remove(Train obj);

    public void update(Train obj);

    public Train find(String arg);

    public Train findByName(String arg);

    public Collection<Train> get();
}
