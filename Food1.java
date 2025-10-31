import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FFrog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Food1 extends Actor {
    public void act() {
        if(isTouching(Snakey.class)) {
            Greenfoot.playSound("bite1.wav");

            World world = getWorld();
            if(world instanceof Level1){
                Level1.score.add(5);
            } else if(world instanceof Level2){
                Level2.score.add(5);
            } else if(world instanceof Level3){
                Level3.score.add(5);
            }

            getWorld().removeObject(this);
            return;
        }
    }
}
