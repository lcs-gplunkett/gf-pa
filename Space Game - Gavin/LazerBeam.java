import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LazerBeam here.
 * 
 * @author (Gavin Plunkett) 
 * @version (April 9, 2019)
 */
public class LazerBeam extends Actor
{
    int aliens = 1;
    /**
     * Constructor
     * Happens once when LazerBeam object is created
     */
    LazerBeam()
    {
        turnTowards(0, 0);
        move(5);
    }
    
    
    
    /**
     * Act - do whatever the LazerBeam wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here
        checkForAlien();
        move();
        
    }    

    

    public void move()
    {
        turnTowards(getX() , (getY() - 245));
        move(5);
        
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    public void checkForAlien()
    {
        if(isTouching(Alien.class))
       {
           removeTouching(Alien.class);
           aliens =- 1;
       }
       
    }
    public void checkWinGame()
    {
        if (aliens == 0)
        {
            Greenfoot.stop();
            String endOfGameMessage = "You Win!";
            getWorld().showText(endOfGameMessage, 248, 123);
        }
    }
}
