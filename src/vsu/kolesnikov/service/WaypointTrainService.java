package vsu.kolesnikov.service;

import vsu.kolesnikov.dao.WaypointTrainStorage;
import vsu.kolesnikov.dao.interfaces.IWaypointTrainRepository;
import vsu.kolesnikov.сomponents.WaypointTrain;

import java.util.Collection;
import java.util.Objects;

public class WaypointTrainService implements IService<WaypointTrain> {
    private final IWaypointTrainRepository storage;

    public WaypointTrainService(WaypointTrainStorage storage) {
        this.storage = storage;
    }
    @Override
    public void add(WaypointTrain obj) {
        storage.add(obj);
    }

    @Override
    public void remove(String... args) {
        get().stream().filter(waypointTrain -> Objects.equals(waypointTrain.getID_waypoint().getID(),Integer.parseInt(args[0]))).findFirst().ifPresent(storage::remove);
    }

    @Override
    public void update(WaypointTrain obj) {
        storage.update(obj);
    }

    @Override
    public WaypointTrain find(String... args) {
        return storage.find(args);
    }

    @Override
    public WaypointTrain findBy(String... args) {
        return storage.findBy(args);
    }

    @Override
    public Collection<WaypointTrain> get() {
        return storage.get();
    }
}
