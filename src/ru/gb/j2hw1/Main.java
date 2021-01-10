package ru.gb.j2hw1;

public class Main {
    public static void main(String[] args) {
        Treadmill treadmill = new Treadmill(16);
        Wall wall = new Wall(2.3);
        Participant robot = new Robot("IBot", 2.5, 25);
        robot.run(treadmill);
        robot.jump(wall);
        Participant[] participants = new Participant[12];
        for (int i = 0; i < participants.length; i++) {
            if (i < 4) {
                participants[i] = new Cat("Cat" + (i + 1), (Math.random() * Cat.MAXHEIGHT),((int) (Math.random() * Cat.MAXDISTANCE)));
            } else if (i >= 4 && i < 8) {
                participants[i] = new Robot("Robot" + (i + 1), (Math.random() * Cat.MAXHEIGHT),((int) (Math.random() * Cat.MAXDISTANCE)));
            } else if (i >= 8) {
                participants[i] = new Human("Human" + (i + 1), (Math.random() * Cat.MAXHEIGHT),((int) (Math.random() * Cat.MAXDISTANCE)));
            }
        }
        Obstacle[] obstacles = new Obstacle[6];
        for (int i = 0; i < obstacles.length; i++) {
            if (i < 3) {
                obstacles[i] = new Wall(Math.random() * Wall.MAXHEIGHT);
            } else {
                obstacles[i] = new Treadmill((int) (Math.random() * Treadmill.MAXDISTANCE));
            }
        }
        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < participants.length; j++) {
                if (participants[j].isDropout()) {
                    continue;
                }
                if (obstacles[i] instanceof Wall) {
                    participants[j].jump((Wall) obstacles[i]);
                } else if (obstacles[i] instanceof Treadmill) {
                    participants[j].run((Treadmill) obstacles[i]);
                }
            }
        }
    }
}
