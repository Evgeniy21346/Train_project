package vsu.kolesnikov.service;

import vsu.kolesnikov.dao.TrainStorage;
import vsu.kolesnikov.dao.interfaces.ITrainRepository;
import vsu.kolesnikov.сomponents.Train;

import java.util.Collection;
import java.util.Objects;

public class TrainService implements IService<Train> {
    private final ITrainRepository storage;

    public TrainService(TrainStorage storage) {
        this.storage = storage;
    }

    @Override
    public void add(Train obj) {
        storage.add(obj);
    }

    @Override
    public void remove(String... args) {
        get().stream().filter(train -> Objects.equals(train.getID(), Integer.parseInt(args[0]))).findFirst().ifPresent(storage::remove);
    }

    @Override
    public void update(Train obj) {
        storage.update(obj);
    }

    @Override
    public Train find(String... args) {
        return storage.find(args[0]);
    }

    @Override
    public Train findBy(String... args) {
        return storage.findByName(args[0]);
    }

    @Override
    public Collection<Train> get() {
        return storage.get();
    }
}
