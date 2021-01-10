package ru.gb.j2hw1;

public class Robot implements Participant {
    private String name;
    private double jumpHeight;
    private int runDistance;
    private boolean dropout = false;
    public static final double MAXHEIGHT = 1.2;
    public static final int MAXDISTANCE = 1500;

    Robot(String name, double jumpHeight, int runDistance) {
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

    public boolean isDropout() {
        return dropout;
    }

    @Override
    public void run(Treadmill treadmill) {
        if (!isDropout()) {
            System.out.println("Робот " + name + " бежит");
            if (getRunDistance() >= treadmill.getDistance()) {
                System.out.println(name + " успешно пробежал(а) на дорожке длинной " + treadmill.getDistance() + " м.");
            } else {
                System.out.println(name + " не смог(ла) пробежать " + treadmill.getDistance() + " м., запас хода " + getRunDistance());
                setDropout(true);
            }
        }
    }

    @Override
    public void jump(Wall wall) {
        if (!isDropout()) {
            System.out.println("Робот " + name + " прыгает");
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
