package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    public List<Room> roomList = new ArrayList<Room>();

    public void addRoom(Double width, Double length, Double height) {
            roomList.add(new Room(width, length, height));
    }

    @Override
    public String toString() {
        if (roomList.isEmpty()) return "No rooms yet.";
        else return roomList.toString();
    }
}
