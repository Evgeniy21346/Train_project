package vsu.kolesnikov.сomponents;

import java.util.Objects;

public class Train {
    private int ID;
    private String name;
    private String route;

    public Train(){

    }

    public Train(int ID, String name, String route){
        this.ID = ID;
        this.name = name;
        this.route = route;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(ID, train.ID);
    }

    @Override
    public String toString() {
        return "Поезд{" +
                "Название='" + name + '\'' +
                ", Маршрут=" + route +
                '}';
    }
}
