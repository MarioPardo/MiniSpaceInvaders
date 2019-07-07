package com.company;



import java.awt.*;

public class Bullet
{
    int x;  //coordinates of bullet
    int y;
    boolean hit;  //if bullet has hit something
    public static int bulletSpeed;  //stores bullet's speed

    public Bullet(int startX, int startY)  //constructor
    {
         x = startX + 15;
         y = startY;

         bulletSpeed = gamePanel.bulletSpeed;


    }

    public void drawBullet(Graphics g)  //draws bullet
    {
        if(!hit) //if hasnt been hit, so is still active
        {
            g.setColor(Color.black);  //draw bullet as black
        }
        else
        {
           return;  //if it did hit, dont draw it
        }
       g.fillRect(x , y - 20, 10, 20);  //draws bullet
        y-= bulletSpeed;  //makes bullet go up at the set speed
    }

    public void checkCollision(Alien alien, Shooter shooter)  //sees if the alien and bullet have it
    {
        if(alien.isHit || hit){ return ;}  //if alien is already hit(dead) or the bullet already hit(is inactive), leave
        if(x  > (alien.currentX - 10 ) && x<= (alien.currentX + 15) && y >= (alien.y - 5) && y <= (alien.y + 10) )  // if the bullet and alien touch
        {
            alien.die();
            hit = true; //bullte has hit, so it's now inactive
            gamePanel.killConfirmed();  //say that there has been a kill


        }

    }





}
