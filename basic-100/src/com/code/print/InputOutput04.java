package com.code.print;

import java.util.Scanner;

public class InputOutput04 {

    //1014
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a, b;
        a = scan.next();
        b = scan.next();
        System.out.println(b + " " + a);

        scan.close();
    }
}
