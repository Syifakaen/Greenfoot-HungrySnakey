import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OverPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OverPage extends World
{

    /**
     * Constructor for objects of class OverPage.
     * 
     */
    public OverPage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(736, 368, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    private void prepare()
    {
        HomeButton homeButton = new HomeButton();
        addObject(homeButton,321,305);
        PlayAgain playAgain = new PlayAgain();
        addObject(playAgain,397,307);
        Greenfoot.playSound("lose.wav");
    }
}
