package com.sample.maris.scavengerhunt;


import org.w3c.dom.NameList;

public class Task {

    int id;
    String name; //name of task
    int points;

    public Task(int Id, String Name, int Points){
        this.id = Id;
        this.name = Name;
        this.points = Points;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
