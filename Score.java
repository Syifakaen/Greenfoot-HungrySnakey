import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor
{
    private int value = 0;

    public Score() {
    }

    public void add(int points) {
        value += points;
    }

    public void setValue(int val) {
        value = val;
    }

    public int getValue() {
        return value;
    }
}