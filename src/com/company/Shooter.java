package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Shooter {


    private int x, y;  //coords of the shooter
    public char direction = 'R';  //direction in which its moving,starts moving right


    ArrayList<Bullet> bulletList = new ArrayList<>();  //list of bullets
    ArrayList<Alien> alienLIst; //list of aliens





    public Shooter(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
        alienLIst = gamePanel.alienlist;  //copies the gamepanel's list of aliens
        bulletList.clear();
    }


    public void draw(Graphics g) {   //draws everything

        //shooter
        g.setColor(Color.RED);
        g.fillRect(x, y, 40, 20); //bottom rect
        g.fillRect(x + 10, y - 10, 20, 10); //top rect


        for (Bullet bullet : bulletList)  //iterates through every bullet
        {
            bullet.drawBullet(g);  //draws bullet

            for (Alien alien : alienLIst)  //iterates through everey alien, and then every bullet checks collision with them
            {
                bullet.checkCollision(alien, this);

            }


        }


    }

        public void shoot()  //shoot bullet
        {
            bulletList.add(new Bullet(x,y));  //add new bullet to bullet list
            Main.playSound("M:\\IntelliJ\\Projects\\Swing Projects\\MiniSpaceInvaders\\Shooting.wav");  //play shooting sound


        }






    public void move()  //moves the shooter
    {
        if (direction == 'R')
        {
            if (x <= 650) //if it's ok to move right, keep moving right
            {
                direction = 'R';
            } else if (x >= 651) //if hit the right wall, move left
            {
                direction = 'L';
            }
        }

        if (direction == 'L')
        {
            if (x > 0)  //if it's ok to go left, keep moving left
            {
                direction = 'L';
            } else if (x == 0)  //if hit the left edge, start moving right
            {
                direction = 'R';
            }

        }

        //moves in the appropriate direction
        if (direction == 'R')
        {
            x++;
            return;
        } else if(direction == 'L')
        {
            x--;
            return;
        }

    }

}



