package com.code.operations;

import java.util.Scanner;

public class Arithmetic1039 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] strArr = s.split(" ");
        long num1 = Long.parseLong(strArr[0]);
        long num2 = Long.parseLong(strArr[1]);
        System.out.println(num1 + num2);
    }
}
