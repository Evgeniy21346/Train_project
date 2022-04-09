package vsu.kolesnikov.сomponents;

import java.sql.Time;
import java.util.Objects;

public class Waypoint {
    private int ID;
    private String station;
    private Time arrivalTime;
    private Time departureTime;

    public Waypoint(){

    }

    public Waypoint(int ID, String station, Time arrivalTime, Time departureTime){
        this.ID = ID;
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getStation() {
        return station;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waypoint waypoint = (Waypoint) o;
        return Objects.equals(ID, waypoint.ID);
    }

    @Override
    public String toString() {
        return "Точка маршрута{" +
                "Станция='" + station + '\'' +
                ", Время прибытия='" + arrivalTime + '\'' +
                ", Время отправления='" + departureTime +
                '}';
    }
}
