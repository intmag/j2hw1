package ru.gb.j2hw1;

public class Cat implements Participant {
    private String name;
    private double jumpHeight;
    private int runDistance;
    private boolean dropout = false;
    public static final double MAXHEIGHT = 2.0;
    public static final int MAXDISTANCE = 3000;

    public boolean isDropout() {
        return dropout;
    }

    Cat(String name, double jumpHeight, int runDistance) {
        setName(name);
        setJumpHeight(jumpHeight);
        setRunDistance(runDistance);
    }

    public int getRunDistance() {
        return runDistance;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public void run(Treadmill treadmill) {
        if (!isDropout()) {
            System.out.println("Кот " + name + " бежит");
            if (getRunDistance() >= treadmill.getDistance()) {
                System.out.println(name + " успешно пробежал(а) на дорожке длинной " + treadmill.getDistance() + " м.");
            } else {
                System.out.println(name + " не смог(ла) пробежать " + treadmill.getDistance() + " м., запас хода " + getRunDistance());
                setDropout(true);
            }
        }
    }

    public void jump(Wall wall) {
        if (!isDropout()) {
            System.out.println("Кот " + name + " прыгает");
            if (getJumpHeight() >= wall.getHeight()) {
                System.out.println(name + " успешно перепрыгнул(а) стену высотой " + wall.getHeight() + " м.");
            } else {
                System.out.println(name + " не смог(ла) перепрыгнуть стену " + wall.getHeight() + " м., максимальная высота прыжка " + getJumpHeight() + " м.");
                setDropout(true);
            }
        }
    }

    public void setDropout(boolean dropout) {
        this.dropout = dropout;
    }
}
