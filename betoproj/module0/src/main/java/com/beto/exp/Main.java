package com.beto.exp;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String x = "Elo Word !" + args[0];

        String y = null;
        try {
            y = f(x);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(y);

        MyFirstClass mfc = new MyFirstClass("aaa", 40, new Date());

        System.out.println(mfc);

    }

    private static String f(String x) {
        String result = x.toUpperCase();
        return result;
    }
}
