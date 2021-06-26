package com.code.print;

import java.util.Scanner;

public class InputOutput03 {

    //1013
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int a, b;
        a = scan.nextInt();
        b= scan.nextInt();
        System.out.println(a + " " + b);

        scan.close();
    }
}
