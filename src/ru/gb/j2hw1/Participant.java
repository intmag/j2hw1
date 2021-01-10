package ru.gb.j2hw1;

public interface Participant {
    void run(Treadmill treadmill);
    void jump(Wall wall);
    boolean isDropout();
}
