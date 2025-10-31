import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Snakey extends Actor
{
    private int frame = 0;
    private GreenfootImage[] images;
    private GreenfootImage[] flippedImages;
    private boolean facingLeft = false;

    public Snakey () {
        images = new GreenfootImage[4];
        flippedImages = new GreenfootImage[4];

        for (int i = 0; i < 4; i++) {
            images[i] = new GreenfootImage("snakey" + (i + 1) + ".png");
            flippedImages[i] = new GreenfootImage(images[i]);
            flippedImages[i].mirrorHorizontally(); // buat versi terbalik
        }

        setImage(images[0]); // gambar awal
    }

    public void act() {
        checkKeyPress();
        animate();
    }

    private void checkKeyPress() {
        if (Greenfoot.isKeyDown("up")) {
            if (getY() - 6 > 130) {
                setLocation(getX(), getY() - 6);
            }
        }

        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 6);
        }

        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 4, getY());
            facingLeft = true;
        }

        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 4, getY());
            facingLeft = false;
        }
    }

    private void animate() {
        frame++;
        int index = (frame / 10) % images.length;

        if (facingLeft) {
            setImage(flippedImages[index]);
        } else {
            setImage(images[index]);
        }
    }
}