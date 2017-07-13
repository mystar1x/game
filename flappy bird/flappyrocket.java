import greenfoot.*;

/**
 * Write a description of class flappyrocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)*/
public class flappyrocket extends Actor
{
    double dy = 0;
    double g=1.3;
    double BOOST_SPEED=-7;
    /**
     * Act - do whatever the flappyrocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private void displayGameOver(){
            gameover Gameover=new gameover();
            getWorld().addObject(Gameover,getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
        
        
        }

    public void act() 
    {
        
        //if we are touching the ufo then game over
        if(getOneIntersectingObject(ufo.class)!= null){
        displayGameOver();        }
        if(getOneIntersectingObject(toppipe.class)!= null){
        displayGameOver();        }
           setLocation(getX(),(int)(getY() + dy));
           //if user pressed up arrow rocket should go up
           if(Greenfoot.isKeyDown("up") == true)
           {
            dy=BOOST_SPEED; 
        
        }
        //if rocket drops out of the world,game over
        if(getY() > getWorld().getHeight()){
           displayGameOver();
        }

        if(dy<10)
        {
            setRotation(-30);
        }
           else if(dy>10)
           {
               setRotation(40);}
                    
        
           dy = dy + g;
    }    
}

