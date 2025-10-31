import greenfoot.*;

public class Predator1 extends Actor
{
    private int speed;
    private int frame = 0;
    private GreenfootImage[] images;
    private boolean isAttacking = false;
    private int attackDelay = 0;

    public Predator1() {
        speed = 1; // kecepatan sedang

        images = new GreenfootImage[4];
        images[0] = new GreenfootImage("biawak1.png");
        images[1] = new GreenfootImage("biawak2.png");
        images[2] = new GreenfootImage("biawak3.png");
        images[3] = new GreenfootImage("biawak4.png");

        setImage(images[0]); // gambar awal
    }

    public void act() {
        if (isAttacking) {
            attackDelay--;
            if (attackDelay <= 0) {
                finishAttack(); // lanjutkan proses setelah delay
            }
            return;
        }

        setLocation(getX() - speed, getY());
        animate();

        if (isTouching(Snakey.class)) {
            Greenfoot.playSound("eating.wav");
            isAttacking = true;
            attackDelay = 15; // tunggu 15 frame sebelum reset
        }

        checkEdge();
    }

    private void finishAttack() {
    World world = getWorld();

    if (world instanceof Level1) {
        ((Level1)world).loseHp(1);
    } else if (world instanceof Level2) {
        ((Level2)world).loseHp(1);
    } else if (world instanceof Level3) {
        ((Level3)world).loseHp(1); 
    }

    Snakey snakey = (Snakey)getOneIntersectingObject(Snakey.class);
    if (snakey != null) {
        snakey.setLocation(32, 203); // reset posisi
    }

    for (Object obj : world.getObjects(Predator1.class)) {
        world.removeObject((Actor)obj);
    }

    if (world instanceof Level2) {
        ((Level2)world).spawnPredator();
    } else if (world instanceof Level3) {
        ((Level3)world).spawnPredator(); 
    }
}


    private void animate() {
        frame++;
        int index = (frame / 10) % images.length;
        setImage(images[index]);
    }

    private void checkEdge() {
        if (getX() <= 0) {
            getWorld().removeObject(this);
        }
    }
}