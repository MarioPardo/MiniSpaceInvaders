////////////////////////////////////////////////////////
//
// Author: Mario Pardo
//
// Date: June 18, 2019
//
// Grade:  Gr10
//
// Course: ICS3U1
//
// Teacher : Mr Baxter
//
// Purpose : This is my simple version of spaceinvaders!
//             It is my culminating project, it uses
//              things we learned in class, and stuff i
//              know from outside of class!
////////////////////////////////////////////////////////










package com.company;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static MainFrame frame; //creates and stores the frame

    public static void main(String[] args) {

        frame = new MainFrame("Stating Menu!");  //creates the frame with that title
        frame.setSize(700,400);  //makes the fram 700* 400 pixels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes it so it closes when red x is pressed
        frame.setVisible(true);  //makes the frame visible




    }

    public static void startGame()  //called when start button is pressed on the starting menu
    {
        frame.setTitle("Space Invaders!");  //sets new title
        frame.setVisible(false);  //sets as inv isible to no glitches
        frame.startGame(); //creates and adds game to screen
        frame.setVisible(true);  //now visible again

    }

    public static void endGame()
    {
            frame.setTitle("Game Ended!");  //sets new title
            frame.setVisible(false);  //sets as invisible to no glitches
            frame.endGame(); //creates and adds game to screen
            frame.setVisible(true);  //now visible again

    }

    public static void restartGame()
    {
        frame.setTitle("Starting Menu!");  //sets new title
        frame.setVisible(false);  //sets as invisible to no glitches
        frame.restartGame(); //creates and adds game to screen
        frame.setVisible(true);  //now visible again
    }


    public static void playSound(String filepath)  //plays sound file
    {

        InputStream sound;  //declares inputstream object

        try
        {
            sound = new FileInputStream(new File(filepath));  //make the sound the file
            AudioStream audios = new AudioStream(sound);  //creates audiostream of file
            AudioPlayer.player.start(audios); //plays sound
        }
        catch(Exception e) //if cant find file
        {

        }
    }

}
