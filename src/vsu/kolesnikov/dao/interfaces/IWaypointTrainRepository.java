package vsu.kolesnikov.dao.interfaces;

import vsu.kolesnikov.сomponents.WaypointTrain;

import java.util.Collection;

public interface IWaypointTrainRepository{
    public void add(WaypointTrain obj);

    public void remove(WaypointTrain obj);

    public void update(WaypointTrain obj);

    public WaypointTrain find(String... args);

    public WaypointTrain findBy(String... args);

    public Collection<WaypointTrain> get();
}
