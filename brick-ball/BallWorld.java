import greenfoot.*;

/**
 * Write a description of class BallWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallWorld extends World
{

    /**
     * makes a random number for every angle
     */
    private int numberx1 = Greenfoot.getRandomNumber(600);
    private int numberx2 = Greenfoot.getRandomNumber(600);
    private int numberx3 = Greenfoot.getRandomNumber(600);
    private int numbery1 = Greenfoot.getRandomNumber(400);
    private int numbery2 = Greenfoot.getRandomNumber(400);
    private int numbery3 = Greenfoot.getRandomNumber(400);
    /**
     * creates the background and the three balls at random locations
     */
    public BallWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * adds the bricks, ball, and bar to the world
     */
    private void prepare()
    {

        Ball ball = new Ball();
        addObject(ball, 210, 129);
        Ball ball29 = new Ball();
        addObject(ball29, 238, 132);
        Ball ball3 = new Ball();
        addObject(ball3, 392, 178);
        Ball ball4 = new Ball();
        addObject(ball4, 465, 199);
        Ball ball5 = new Ball();
        addObject(ball5, 417, 180);
        Ball ball6 = new Ball();
        addObject(ball6, 383, 172);
        Ball ball7 = new Ball();
        addObject(ball7, 413, 171);
        Ball ball8 = new Ball();
        addObject(ball8, 374, 169);
        ball.setLocation(196, 115);
        ball.setLocation(198, 117);
        ball29.setLocation(229, 117);
        ball8.setLocation(215, 132);
        ball6.setLocation(260, 116);
        ball3.setLocation(247, 132);
        ball7.setLocation(291, 116);
        ball5.setLocation(278, 132);
        ball4.setLocation(231, 147);
        Ball ball9 = new Ball();
        addObject(ball9, 270, 155);
        Ball ball10 = new Ball();
        addObject(ball10, 476, 192);
        Ball ball11 = new Ball();
        addObject(ball11, 435, 192);
        Ball ball12 = new Ball();
        addObject(ball12, 510, 207);
        Ball ball13 = new Ball();
        addObject(ball13, 484, 202);
        Ball ball14 = new Ball();
        addObject(ball14, 494, 205);
        Ball ball15 = new Ball();
        addObject(ball15, 431, 193);
        Ball ball16 = new Ball();
        addObject(ball16, 399, 188);
        Ball ball17 = new Ball();
        addObject(ball17, 403, 210);
        ball16.setLocation(322, 115);
        ball15.setLocation(309, 132);
        ball9.setLocation(262, 148);
        ball17.setLocation(293, 148);
        ball11.setLocation(353, 115);
        ball10.setLocation(341, 132);
        ball14.setLocation(324, 148);
        ball13.setLocation(355, 149);
        ball12.setLocation(373, 132);
        Ball ball18 = new Ball();
        addObject(ball18, 516, 161);
        ball18.setLocation(384, 116);
        Ball ball19 = new Ball();
        addObject(ball19, 381, 211);
        Ball ball20 = new Ball();
        addObject(ball20, 401, 211);
        Ball ball21 = new Ball();
        addObject(ball21, 438, 217);
        Ball ball22 = new Ball();
        addObject(ball22, 462, 222);
        Ball ball23 = new Ball();
        addObject(ball23, 470, 210);
        Ball ball24 = new Ball();
        addObject(ball24, 464, 204);
        ball19.setLocation(245, 162);
        ball20.setLocation(276, 163);
        ball21.setLocation(307, 163);
        ball24.setLocation(339, 164);
        ball22.setLocation(323, 179);
        ball23.setLocation(292, 179);
        Ball ball25 = new Ball();
        addObject(ball25, 268, 187);
        ball25.setLocation(260, 179);
        Ball ball26 = new Ball();
        addObject(ball26, 463, 223);
        Ball ball27 = new Ball();
        addObject(ball27, 393, 218);
        Ball ball28 = new Ball();
        addObject(ball28, 336, 217);
        ball28.setLocation(272, 195);
        ball27.setLocation(304, 195);
        ball26.setLocation(289, 211);
        ball.setLocation(198, 64);
        ball29.setLocation(229, 65);
        ball6.setLocation(260, 66);
        ball7.setLocation(289, 65);
        ball7.setLocation(291, 65);
        ball16.setLocation(323, 66);
        ball11.setLocation(354, 65);
        ball18.setLocation(385, 65);
        ball8.setLocation(214, 80);
        ball3.setLocation(246, 80);
        ball3.setLocation(245, 80);
        ball5.setLocation(277, 82);
        ball15.setLocation(309, 82);
        ball10.setLocation(340, 83);
        ball12.setLocation(371, 83);
        ball4.setLocation(230, 96);
        ball9.setLocation(261, 96);
        ball17.setLocation(293, 98);
        ball14.setLocation(324, 98);
        ball13.setLocation(355, 99);
        ball24.setLocation(335, 114);
        ball21.setLocation(304, 114);
        ball20.setLocation(272, 114);
        ball19.setLocation(240, 113);
        ball25.setLocation(256, 129);
        ball23.setLocation(288, 131);
        ball22.setLocation(319, 130);
        ball23.setLocation(288, 129);
        ball28.setLocation(270, 145);
        ball27.setLocation(301, 146);
        ball26.setLocation(282, 161);
        Bar bar = new Bar();
        addObject(bar, 293, 399);
        Ball2 ball2 = new Ball2();
        addObject(ball2, 293, 359);
    }
}
