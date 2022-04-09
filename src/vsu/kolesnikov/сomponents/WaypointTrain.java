package vsu.kolesnikov.сomponents;

import java.util.Objects;

public class WaypointTrain {
    private Waypoint ID_waypoint;
    private Train ID_train;
    private int Number;

    public WaypointTrain() {

    }

    public WaypointTrain(Waypoint waypoint, Train train, int number) {
        this.ID_waypoint = waypoint;
        this.ID_train = train;
        this.Number = number;
    }

    public void setID_waypoint(Waypoint ID_waypoint) {
        this.ID_waypoint = ID_waypoint;
    }

    public Waypoint getID_waypoint() {
        return ID_waypoint;
    }

    public void setID_train(Train ID_train) {
        this.ID_train = ID_train;
    }

    public Train getID_train() {
        return ID_train;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaypointTrain waypoint_train = (WaypointTrain) o;
        return Objects.equals(ID_waypoint, waypoint_train.ID_waypoint)
                && Objects.equals(ID_train, waypoint_train.ID_train);
    }

    @Override
    public String toString() {
        return "Поезд{" +
                "Точка маршрута='" + ID_waypoint.getStation() + '\'' +
                ", Поезд=" + ID_train.getName() + '\'' +
                ", Номер=" + Number +
                '}';
    }
}
