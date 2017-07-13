import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class score extends Actor
{
    /**
     * Act - do whatever the score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public score() 
    {
        // Add your action code here.
        GreenfootImage newImage = new GreenfootImage(100,50);
      
        setImage(newImage);
    }    
public void setscore(int score){
GreenfootImage newImage=getImage();
newImage.clear();
Font f=new Font("Comic Sans Ms",Font.PLAIN,32);
Color c=new Color(127,127,127,127); 
newImage.setColor(Color.blue);
       newImage.fill();
       newImage.setColor(Color.black);
       
newImage.drawString(""+score,30,30);
setImage(newImage);

}

}
