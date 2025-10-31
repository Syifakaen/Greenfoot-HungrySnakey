import greenfoot.*;

public class Predator2 extends Actor
{
    private int speed;
private int frame = 0;

    public Predator2() {
        speed = 3; // kecepatan cepat
        Greenfoot.playSound("eagle.wav");
    }

    public void act()
    {
         frame++;
    int wave = (int)(5 * Math.sin(frame * 0.1)); // gelombang naik-turun
    setLocation(getX() - speed, getY() + wave);



        if (isTouching(Snakey.class)) {
            Greenfoot.playSound("eating.wav");

            World world = getWorld();

            // Kurangi HP
            if (world instanceof Level2) {
                ((Level2)world).loseHp(1);
            } else if (world instanceof Level3) {
                ((Level3)world).loseHp(1);
            }

            // Reset posisi ular
            Snakey snakey = (Snakey)getOneIntersectingObject(Snakey.class);
            if (snakey != null) {
                snakey.setLocation(32, 203); // posisi awal
            }

            // Hapus semua predator
            for (Object obj : world.getObjects(Predator2.class)) {
                world.removeObject((Actor)obj);
        
            }

            // Delay sebentar sebelum respawn
            Greenfoot.delay(10);

            // Respawn predator baru
            if (world instanceof Level3) {
                ((Level3)world).spawnPredator();
            }

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