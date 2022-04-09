package vsu.kolesnikov.service;

import vsu.kolesnikov.dao.WaypointStorage;
import vsu.kolesnikov.dao.interfaces.IWaypointRepository;
import vsu.kolesnikov.сomponents.Waypoint;

import java.util.Collection;
import java.util.Objects;

public class WaypointService implements IService<Waypoint> {
    private final IWaypointRepository storage;

    public WaypointService(WaypointStorage storage) {
        this.storage = storage;
    }

    @Override
    public void add(Waypoint obj) {
        storage.add(obj);
    }

    @Override
    public void remove(String... args) {
        get().stream().filter(waypoint -> Objects.equals(waypoint.getID(), Integer.parseInt(args[0]))).findFirst().ifPresent(storage::remove);
    }

    @Override
    public void update(Waypoint obj) {
        storage.update(obj);
    }

    @Override
    public Waypoint find(String... args) {
        return storage.find(args[0]);
    }

    @Override
    public Waypoint findBy(String... args) {
        return storage.findByStation(args[0]);
    }

    @Override
    public Collection<Waypoint> get() {
        return storage.get();
    }
}
