package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Array;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.Format;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.*;

public class HighScoreListClass
{
    //for highscore list
    public static Formatter formatter;  //stores the formatter which outputs to the file

    public static Scanner scanner; //reads the file

    public static FileWriter f; //object which writes to the file

    public static ArrayList<Score> SortedScores ; //stores all the scores when they're already sorted




    public static void openFile() //called when the winmenu is constructed
    {
        //creates the objects to read and write to the file

        try{
             f = new FileWriter("Scores.txt", true);
            formatter = new Formatter(f);

            scanner = new Scanner(new File("Scores.txt  "));


        }catch(Exception e)
        {
            System.out.println("You have An Error!");
        }



    }

    public static void addScore(Score score) //adds score to scores.txt
    {
        //new line
        String newline = System.getProperty("line.separator");

        //getScorePosition
        formatter.format("%n %s %s",score.points ,  score.name , newline);

        formatter.close(); //for bugs, if not closed then huge problems!

    }


    public static Score[] getHighScores(int number)  //returns top top (number) arrays
    {
        Score[] scoreArray = new Score[number];  //creates the array that will be returned

        for(int i = 0; i < number; i++) //gets number amount of scores
        {
            try {
                scoreArray[i] = SortedScores.get(i); //gets the score
            }
            catch(Exception e)
            {
                System.out.println("Not enough players in list to make list!");
            }
        }


       return scoreArray;


    }

    public static void sortScores()
    {
        System.out.println("Sorting Scores");

        SortedScores = new ArrayList<Score>(); //creates new array, therefore clearing it from past uses

        try {  //creates a new scanner so that it scans from the top of the file again
            scanner = new Scanner(new File("Scores.txt"));
        }
        catch(Exception e)
        {
            System.out.println("Problem opening file");
        }

        while(scanner.hasNext())  //entire file
        {
            double score = 0.0;
            try{
                 score = Double.parseDouble(scanner.next());  //stores the score
            }
            catch  (Exception e)
            {
            }


            String name = scanner.next();  //stores the name

            SortedScores.add(new Score(score,name));  //adds this score to the
        }

        Collections.sort(SortedScores,Collections.<Score>reverseOrder()); // sorts the arraylist, reverse order makes it go from largest to least


    }





}
