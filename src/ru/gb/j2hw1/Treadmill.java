package ru.gb.j2hw1;

public class Treadmill implements Obstacle{
    public static final int MAXDISTANCE = 50000;
    protected int distance;

    Treadmill(int distance) {
        setDistance(distance);
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
