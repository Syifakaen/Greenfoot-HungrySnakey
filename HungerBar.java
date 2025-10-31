import greenfoot.*;

public class HungerBar extends Actor
{
    private int progress = 0; // nilai internal untuk bar

    public void act()
    {
        updateImage();
    }

    public void setProgress(int value)
    {
        progress = value;
        updateBar();
    }

    // Update berdasarkan skor dari Level1, Level2, atau Level3
    private void updateImage()
    {
        int score = 0;

        World world = getWorld();
        if (world instanceof Level1) {
            score = Level1.score.getValue();
        } else if (world instanceof Level2) {
            score = Level2.score.getValue();
        } else if (world instanceof Level3) {
            score = Level3.score.getValue();
        }

        progress = score; // sinkronkan progress dengan skor
        updateBar();
    }

    // Gambar ulang bar berdasarkan progress
    private void updateBar()
    {
        if(progress < 20)
        {
            setImage("HungerBar1.png");
        }
        else if(progress < 40)
        {
            setImage("HungerBar2.png");
        }
        else if(progress < 60)
        {
            setImage("HungerBar3.png");
        }
        else if(progress < 80)
        {
            setImage("HungerBar4.png");
        }
        else if(progress < 100)
        {
            setImage("HungerBar5.png");
        }
        else
        {
            setImage("HungerBar6.png");
        }
    }
}