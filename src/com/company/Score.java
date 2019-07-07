package com.company;

import java.util.Comparator;

public class Score implements Comparable<Score>
{
    double points;
    String name;

    public Score(double p, String n)
    {
        points = p;
        name = n;
    }

    @Override
    public int compareTo(Score c)  //used for when sorting scores
    {
        if (this.points > c.points) {
            return 1;
        }
        if (this.points == c.points) {
            return 0;
        } else {
            return -1;
        }

    }

    public class ScoreComparator implements Comparator<Score> //necessary to use collections.sort()
    {
        public int compare(Score s1, Score s2)
        {
            return s1.compareTo(s2);
        }
    }



    }
