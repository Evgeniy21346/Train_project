package vsu.kolesnikov.dao.interfaces;


import vsu.kolesnikov.сomponents.Waypoint;

import java.util.Collection;

public interface IWaypointRepository {
    public void add(Waypoint obj);

    public void remove(Waypoint obj);

    public void update(Waypoint obj);

    public Waypoint find(String arg);

    public Waypoint findByStation(String arg);

    public Collection<Waypoint> get();
}
