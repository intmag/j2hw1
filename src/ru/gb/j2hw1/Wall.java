package ru.gb.j2hw1;

public class Wall implements Obstacle{
    public static final double MAXHEIGHT = 3.0;
    protected double height;

    Wall(double height) {
        setHeight(height);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
}
