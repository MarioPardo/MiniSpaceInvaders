package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class winMenu extends JPanel
{

    JButton restartButton = new JButton("Restart Game!");

    Score[] scores;





    public winMenu()
    {
        setLayout(new BorderLayout());  //sets layout

        add(restartButton,BorderLayout.PAGE_END);

        restartButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   //this is when pressed
                System.out.println("Restart");
                Main.restartGame();
            }

        });

        HighScoreListClass.openFile();

        HighScoreListClass.addScore(new Score(gamePanel.points, startingMenu.name));

        HighScoreListClass.sortScores();

        scores = HighScoreListClass.getHighScores(3);





    }


    public void paintComponent(Graphics g)  // this paints everything
    {
        super.paintComponent(g);  //constructor of parent class
        this.setBackground(Color.white.white);  //sets background to white


        g.setColor(Color.black);    //kill count
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));  //creates new font
        g.drawString("VICTORY!", 250, 50);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));  //creates new font
        g.drawString("Kills: " + Integer.toString(gamePanel.kills),  80, 150);  //writes the kill count
        g.drawString("Bullets Fired: " + Integer.toString(gamePanel.shots), 80, 200);

        g.drawString("Precision: " + gamePanel.kills + "/" + gamePanel.shots, 80, 250);
        g.drawString("Points: " + gamePanel.points ,80, 300 );


        //HIGHSCORES
        g.setFont(new Font("TimesRoman",  Font.BOLD, 30));  //creates new font
        g.drawString("HIGH SCORES!",  420, 125);  //writes the kill count

        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));  //creates new font

        int x = 450, y = 130  ;

        for(Score score : scores)
        {

            y += 40;
            g.drawString(score.name + ": " + score.points + " Points!",  x , y );  //writes the kill count
        }



    }





    ////////



}
