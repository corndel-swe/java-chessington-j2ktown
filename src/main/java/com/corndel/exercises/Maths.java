package com.corndel.exercises;

public class Maths {
    public static double PI = 3.14;

    public static double max(double a, double b){
        if ( a > b){
            return a;
        }
        return b;
    }

    public static int round(double number) {
        int floor = (int) number;

        if (floor == number){
            return floor;
        }

        double remainder = number - floor;
        if (remainder >= 0.5){
            return floor + 1;
        }

        return floor;
    }

    public static double absolute(double number){
        if (number < 0){
            number *= -1;
        }
        return number;
    }


}