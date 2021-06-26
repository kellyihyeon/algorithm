package com.code.print;

import java.util.Scanner;

public class InputOutput05 {

    //1015
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        float a = scan.nextFloat();
        System.out.printf("%.2f", a);

        scan.close();
    }
}
