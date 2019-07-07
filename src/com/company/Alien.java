package com.company;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class Alien {

    public char direction; //direction which alien is going in
    public int originalx;
    public int currentX;
    public int deathX;  //where alien died
    public int y;
    public boolean isHit = false;  // if alien has been hit
    public static int moveDistance;  //how much it has to move each side
    public long deathTime;  //what time it died

    int movePerFrame = (moveDistance / MainFrame.frameRate) ;  //this is so that it makes one full back and forth in one second


    public Alien(int xCoord, int yCoord, char moveDirection)
    {
        originalx = xCoord;
        currentX = xCoord;
        y = yCoord;
        direction = moveDirection;
        moveDistance = 700 - originalx;  //this makes it so that no matter how many aliens, they will reach the edges of the screen
        movePerFrame = (moveDistance / MainFrame.frameRate) * 2;  //makes it so it takes 1 second to do full oscilation


    }


    public void draw(Graphics g) {


        if (!isHit) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.white);
        }
        //torso
        g.fillRect(currentX, y, 15, 10);

        //head
        g.fillRect(currentX + 2, y - 5, 10, 5);

        //feet
        g.fillRect(currentX + 2, y + 10, 3, 2); //left foot
        g.fillRect(currentX + 10, y + 10, 3, 2); //right foot


        //draw explosion
        if (isHit)
        {
            g.setColor(Color.RED);
            g.fillOval(deathX + 2, y + 5, 20, 20);
            g.setColor(Color.yellow);
            g.fillOval(deathX + 6, y + 9, 10, 10);


            //after 2 seconds, make them "dissapear"
            if((System.currentTimeMillis() > (deathTime + 2000)))   //2 s after death
            {
                g.setColor(Color.white);
                g.fillOval(deathX + 2, y + 5, 20, 20);
                g.setColor(Color.white);
                g.fillOval(deathX + 6, y + 9, 10, 10);
            }


        }


    }


    public void moveSideToSide()
    {

        if (currentX >= (originalx + moveDistance)) //if hit the right side, start going left
        {
            direction = 'L';
        }
        if (currentX <= (originalx - moveDistance)) //hit hit the left side, start going right
        {
            direction = 'R';
        }



        if (direction == 'R')   //move the according direction
        {
            currentX += movePerFrame;
        } else {
            currentX -= movePerFrame;
        }
    }

    public void die() //called when alien is hit
    {
        isHit = true;
        deathX = currentX; //sets the death posision as what it is now, used for drawing death scene
        deathTime = System.currentTimeMillis();  //sets the death time
        playExplosion();
    }


    public static void playExplosion()
    {
        Main.playSound("M:\\IntelliJ\\Projects\\Swing Projects\\MiniSpaceInvaders\\Explosion.wav");

    }




    ///////////////////////////////////////static methods








    public static ArrayList createAliens(int rows, int columns) //creates an arraylist of aliens  //arrays and rows are switched and trying to fix it gave weird bugs
    {
        ArrayList list = new ArrayList();

        int alienY = 50; //start 50px down

        for (int i = 0; i < columns; i++) //for every row
        {

            int alienX = 50; //start 50 px in

            for (int b = 0; b < rows; b++)  //for every column
            {
                if (i % 2 == 0) //every 2 rows, make them start moving left   makes them not move all to one direction but instead one row left, one right
                {
                    alienX += (600 / (rows + 1));
                    list.add(new Alien(alienX, alienY, 'L'));

                } else
                    {
                    alienX += (600 / (rows + 1));
                    list.add(new Alien(alienX, alienY, 'R'));
                }

            }

            alienY += 75; //for every row, make it go 75px lower

        }
        return list;  //once done, return the list of aliens!
    }

}
/*

 */