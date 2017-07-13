import greenfoot.*;

/**
 * Write a description of class toppipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class toppipe extends Actor
{
   int ufo=-6;
    /**
     * Act - do whatever the ufo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        GreenfootImage image=getImage();
        setLocation(getX()+ufo,getY());
       
    }    
}
