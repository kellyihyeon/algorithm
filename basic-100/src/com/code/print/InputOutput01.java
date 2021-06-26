package com.code.print;

import java.util.Scanner;

public class InputOutput01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 1010
        int n = scan.nextInt();
        System.out.println(n);

        // 1011
        String string = scan.next();
        System.out.println(string);

        scan.close();


    }
}
