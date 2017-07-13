import greenfoot.*;

/**
 * Write a description of class ufo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ufo extends Actor
{
    
     
    int ufo_speed=-8;
    /**
     * Act - do whatever the ufo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        GreenfootImage image=getImage();
        setLocation(getX()+ufo_speed,getY());
       
    }    
}
