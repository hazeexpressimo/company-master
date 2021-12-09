package com.example.company.data;

import java.time.LocalTime;

public class Department {
    private int id;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private int floor;

    public Department(int id, String name, LocalTime startTime, LocalTime endTime, int floor) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.floor = floor;
    }

    public Department(int id, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Department() {
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
