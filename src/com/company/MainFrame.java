package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame implements KeyListener
{

    gamePanel game = new gamePanel();  //creates and stores the panel to draw on
    startingMenu menu = new startingMenu();  //creates and stores the mainmenu panel
    winMenu win;  //declares winmenu

    public static int bulletSpeed;

    public static int frameRate = 250; //around, calculated
    public static boolean hasRestated = false;  //if user has restarted yet


    public MainFrame(String title) //constructor
    {
        super(title);  //parent class' constructor
        addKeyListener(this); //adds key listener to this object(MainFrame)
        getContentPane().add(menu); //adds the panel to this frame (this is how it starts)


    }

    public void startGame()  //called by main
    {
        System.out.println("Starting Game");
        getContentPane().remove(menu);  //removes the menu fromm the frame

        if(hasRestated) //if user wants to restart
        {
            game.reset();
           game = new gamePanel(); //create new game

        }

        getContentPane().add(game);  //adds the game to the frame
        game.bulletSpeed = menu.bulletSpeed;  //sets the bullet speed to what was picked in the menu

        validate(); //restructures the gui, so it works! (necessary)
    }

    public void endGame() //called by gamePanel
    {
        System.out.println("You Won!!");
        getContentPane().remove(game);  //removes game from wiew
        win = new winMenu();  //creates new win menu
        getContentPane().add(win);  //adds winmenu to view
        validate(); //necessary to restructure gui
    }

    public void restartGame()
    {
        System.out.println("Restarting");
        hasRestated = true;
        getContentPane().remove(win);
        menu = new startingMenu();
        getContentPane().add(menu);
        validate();
    }

 ////////////////////keyboard listener functions
    public void keyTyped(KeyEvent e)
    {
      //not used
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) //if right arrow is pressed
        {
                game.shooter.direction = 'R';
                return;
        }

        else if(e.getKeyCode() == KeyEvent.VK_LEFT) //if left arrow is pressed
        {
            game.shooter.direction = 'L';
            return;
        }

        if(e.getKeyCode() ==KeyEvent.VK_SPACE) //if spacebar is pressed
        {
            game.shooter.shoot();
            game.shots ++;

        }


    }

    public void keyReleased(KeyEvent e)
    {
        //not used
    }




}
