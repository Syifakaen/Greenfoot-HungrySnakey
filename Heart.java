import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeartIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;

public class Heart extends Actor implements HealthSystem
{
    private int hp;

    public Heart(int initialHp) {
        this.hp = initialHp;
        updateHpDisplay();
    }

    public void loseHp(int amount) {
        hp -= amount;
        if(hp < 0) hp = 0;
        updateHpDisplay();
    }

    public void updateHpDisplay() {
        if(hp >= 4) setImage("Heart1.png");
        else if(hp == 3) setImage("Heart2.png");
        else if(hp == 2) setImage("Heart3.png");
        else if(hp == 1) setImage("Heart4.png");
        else Greenfoot.setWorld(new OverPage());}

    public int getHp() {
        return hp;
    }
}
