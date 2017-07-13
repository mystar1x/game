import greenfoot.*;

/**
 * Write a description of class Ball2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball2 extends Actor
{
    private int bricksBroken = 0;
    /**
     * Turns the ball at a random degree if it is at the edge
     */
    public void touchEdge()
    {
        if (isAtEdge())
        {
            int angle = Greenfoot.getRandomNumber(360);
            turn(angle);
        }
    }
    /**
     * Turns the ball at a random degree if it touches a brick, removes the brick, and adds one to the counter
     * If the amount of bricks reaches 28, which is all of them, the scenario stops
     */
    public void touchBall()
    {
        if (isTouching(Ball.class))
        {
            int angle = Greenfoot.getRandomNumber(360);
            turn(angle);
        }
        if( isTouching(Ball.class) )
        {
            removeTouching(Ball.class);
            bricksBroken = bricksBroken + 1; 
            if (bricksBroken == 28)
            {
                Greenfoot.stop();
            }
        }
    }
    /**
     * Turns the ball at a random degree if it touches the bar
     */
    public void touchBar()
    {
         if (isTouching(Bar.class))
        {
            int angle = Greenfoot.getRandomNumber(360);
            turn(angle);
        }
    }
   
         
    /**
     * Moves the ball, checks if it needs to turn at all, and if it needs to remove a brick
     */
    public void act() 
    {
        move(5);
        touchEdge();
        touchBall();
        touchBar();
    }    
}
