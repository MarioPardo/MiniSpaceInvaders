package com.company;
import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class gamePanel extends JPanel implements ActionListener
{

    /// variables that dont have to do with gameplay, but things about the game itself
    Timer timer = new Timer(1,this);  //creates timer that updates every second
    static long frame = 0; //stores which frame the game is at
    static long startTime;
    static long endTime;

    //variables about the game itself
    static int kills = 0;
    static int shots = 0;
    static int bulletSpeed;
    static double points;

    Shooter shooter;  //declares the shooter, not initialized yet
    static ArrayList<Alien> alienlist = new ArrayList(); ///list of aliens




    public gamePanel() //constructor, copies this alienlist to the shooter's alienlist
    {
        startTime = System.currentTimeMillis();  //gets the starting time of the game
        alienlist = new ArrayList(); //new arraylist of aliens
       alienlist = Alien.createAliens(1,2);  //creates the aliens, columns and rows flipped for some reason and couldnt fix

        shooter = new Shooter(330, 350); //initializes the shooter. Done now so that the alienlist is already made so when that list is copied to the shooter's alienlist, it's fullz!



    }

    public void reset()  //when game ends
    {
        alienlist.clear();
        shots = kills = 0;
        points = 0;
        shooter.bulletList.clear();
    }




    public void paintComponent(Graphics g)  // this paints everything
    {
        super.paintComponent(g);  //constructor of parent class
        this.setBackground(Color.white);  //sets background to white


        for(Alien alien: alienlist)  // iterates through evey aline
        {

            if(frame % 2 == 0)  //every two frames
            {
                alien.moveSideToSide();  //makes it move
            }
                alien.draw(g); //draws it


        }


        shooter.draw(g); //draws the shooter

        g.setColor(Color.black);    //kill count
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));  //creates new font
        g.drawString("Kills: " + Integer.toString(kills),  600, 20);  //writes the kill count

        points = kills * gamePanel.bulletSpeed;  //calculates the points, the higher the bullet speed the more points!

      //  if(points > 0)
       // {
        //    points = points - ( 1- kills/shots); //if you have 90% accuracy, only take away 0.1 while if you have 10, take away 0.9!
       // }

        g.drawString("Points: " + points, 450, 20);  //writes the point count

        g.drawString("Shots :" + shots, 50, 20);

        timer.start();  // starts timer

    }

    public void actionPerformed(ActionEvent e)  //called by timer, so every frame
    {
        frame ++; //update the frame count

        shooter.move();  //make the shooter move


        repaint();  //calles the painComponent Method




    }


    public static  void killConfirmed()  //called when there is a kill
    {
        endTime = System.currentTimeMillis();
        kills++;  //increases the kill counter

        for(Alien alien: alienlist)  // iterates through evey alien
        {
            alien.movePerFrame ++;    //evey time there's a kill, make the rest of the aliens move faster


        }


        if(kills == alienlist.size())
        {
          Main.endGame();
            System.out.println(points);

        }

    }












}
