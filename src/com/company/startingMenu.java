package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startingMenu extends JPanel
{
    private JLabel titleLbl = new JLabel("                            SPACE INVADERS");
    private JButton startBtn = new JButton();  //start game butotn
    private JTextField bulletSpeedTxt = new JTextField();  //text field to enter bullet speed
    private JTextField nameTxt = new JTextField();

    public int bulletSpeed;  //stores bulletspeed
    public static String name;




        public startingMenu() //constructor, copies this alienlist to the shooter's alienlist
        {
            setLayout(new BorderLayout());  //sets layout



            //start button
            startBtn.setBackground(Color.white);  //makes butotn white
            startBtn.setFont(new Font("TimesRoman", Font.PLAIN, 30)); //sets button font
            startBtn.setText("START!");  //makes button say start
            startBtn.addActionListener(new ActionListener()
            {
             public void actionPerformed(ActionEvent e)
             {   //this is when pressed
                 bulletSpeed = Integer.parseInt(bulletSpeedTxt.getText());  //store the bullet speed entered
                 name = nameTxt.getText();
                 Main.startGame();  //calls start game method on main

             }

            });
            add(startBtn,BorderLayout.SOUTH);  //puts the button at bottom of screen

            //bullet speed
            bulletSpeedTxt.setText("Enter your desired Bullet Speed!");
            add(bulletSpeedTxt,BorderLayout.LINE_START); //puts textbox in middle of screen

            bulletSpeedTxt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {  //when enter key is pressed
                    bulletSpeed = Integer.parseInt(bulletSpeedTxt.getText());  //save the bulletspeed

                }
            });

            //name
            nameTxt.setText("Please Enter your Name");
            add(nameTxt,BorderLayout.LINE_END); //puts textbox in middle of screen

            bulletSpeedTxt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {  //when enter key is pressed
                    name = nameTxt.getText();  //save the bulletspeed

                }
            });

            titleLbl.setBackground(Color.white);
            titleLbl.setFont(new Font("TimesRoman", Font.PLAIN, 30)); //sets button font
            add(titleLbl, BorderLayout.PAGE_START);

        }




}
