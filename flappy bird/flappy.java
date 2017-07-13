import greenfoot.*;

/**
 * Write a description of class flappy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class flappy extends World
{
int ufocounter=0;
int ufcounter=0;
int ufo_spacing=150;
int score=0;
int first_ufo=240;
score scoeobj=null;
    /**
     * Constructor for objects of class flappy.
     * 
    
       */
    private void createufo()
    {
        ufo Ufo=new ufo();
    GreenfootImage image=Ufo.getImage();
    addObject(Ufo,getWidth(),getHeight()/2+image.getHeight()/2);
}
private void createufo2()
    {
        ufo2 Ufo2=new ufo2();
    GreenfootImage image=Ufo2.getImage();
    addObject(Ufo2,getWidth(),getHeight()/2+image.getHeight()/2);
}
private void createufo3()
    {
        tree Ufo3=new tree();
    GreenfootImage image=Ufo3.getImage();
    addObject(Ufo3,getWidth(),getHeight()/2+image.getHeight()/2);
}
private void createufo4()
    {
        grass Ufo4=new grass();
    GreenfootImage image=Ufo4.getImage();
    addObject(Ufo4,getWidth(),getHeight()/2+image.getHeight()/2);
}

private void createufo5()
    {
        toppipe Ufo5=new toppipe();
    GreenfootImage image=Ufo5.getImage();
    addObject(Ufo5,getWidth()/2,getHeight()/-12+image.getHeight()/-12);
}
      public flappy()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,false); 
        //set paint order
        setPaintOrder(flappyrocket.class,ufo.class,toppipe.class,gameover.class,ufo2.class,tree.class,grass.class);
        //create a flappyrocket project
        flappyrocket rocket=new flappyrocket();
        //add flappy to out world
        addObject(rocket,70,getHeight()/2);
        //create a score object
        scoeobj=new score();
scoeobj.setscore(0);    
    //add it to the world
addObject(scoeobj,100,100);
}
    public void act(){
    ufocounter++;
   // System.out.println(counter);
    if(ufocounter%100==0){
    createufo();    
    createufo2();
    createufo3();
    createufo4();
    createufo5();
}
if(ufocounter>=first_ufo){
if(ufcounter%100==0){
   
    score++;
scoeobj.setscore(score);

}
ufcounter++;    
    }
}
}
