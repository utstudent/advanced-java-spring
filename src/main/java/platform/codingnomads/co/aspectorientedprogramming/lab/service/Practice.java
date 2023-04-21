package platform.codingnomads.co.aspectorientedprogramming.lab.service;

import java.text.DecimalFormat;

public class Practice {

    public static void main(String[] args) {


        String answer = seriesSum(58);
        System.out.println(answer);


    }

    public static String seriesSum(int n) {
        // Happy Coding ^_^
        if (n==0) {
            return "0.00";
        }
        double sum = 1.00;
        int increment = 3;

        for (int i = 0 ; i<=n-2; i++) {
            sum = sum + (double) 1/((i+1)+increment);
            increment += 2;
        }
        return String.format("%.2f", sum);
    }
}
