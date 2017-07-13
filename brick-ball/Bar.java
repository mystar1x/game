import greenfoot.*;

/**
 * Write a description of class Bar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bar extends Actor
{
    /**
     * moves 5 to the left if the key is pressed, and 5 to the right if the right key is pressed
     */
    public void checkKeypress()
    {
        if ( Greenfoot.isKeyDown("left"))
        {
            move(-5);
        }
        if ( Greenfoot.isKeyDown("right")) 
        {
            move(5);
        }
    }
    /**
     *calls key press
     */
    public void act() 
    {
       checkKeypress();
    }    
}
