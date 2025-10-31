import greenfoot.*;

public class Food3 extends Actor
{
    private int speed;
    private int frame = 0;
    private GreenfootImage[] images;


    public Food3() {
        speed = 2; // kecepatan sedang
        images = new GreenfootImage[2];
        images[0] = new GreenfootImage("frog1.png");
        images[1] = new GreenfootImage("frog2.png");

        setImage(images[0]); // gambar awal
    
    }
 

    public void act ()
    {
        setLocation(getX() - speed, getY());
        animate();

        if(isTouching(Snakey.class)) {
            Greenfoot.playSound("bite3.wav");

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
     private void animate()
    {
        frame++;

        // Ganti gambar setiap 10 frame
        int index = (frame / 10) % images.length;
        setImage(images[index]);
    }


    private void checkEdge() { 
        if (getX() <= 0) {
            getWorld().removeObject(this);
        }
    }
}