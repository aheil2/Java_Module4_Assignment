package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    public List<Wall> wallList;

    public Room(Double width, Double length, Double height) {
        wallList = new ArrayList<Wall>(){{
            add(new Wall(width, height));
            add(new Wall(width, height));
            add(new Wall(length, height));
            add(new Wall(length, height));
        }};
    }

    public double getArea() {
        return wallList.get(0).getArea() + wallList.get(1).getArea() + wallList.get(2).getArea() + wallList.get(3).getArea();
    }

    @Override
    public String toString() {
        return String.format("Room with area: %s", getArea());
    }
}
