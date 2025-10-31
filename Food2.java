import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FRAt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food2 extends Actor
{
    private int speed;
    private int frame = 0;

    public Food2() {
        speed = 1; // kecepatan sedang
    }
 

    public void act ()
    {
        setLocation(getX() - speed, getY());

        if(isTouching(Snakey.class)) {
            Greenfoot.playSound("bite2.wav");

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

        checkEdge(); 
    }

    private void checkEdge() { 
        if (getX() <= 0) {
            getWorld().removeObject(this);
        }
    }
}
