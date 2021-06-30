package com.code.print;

import java.util.Scanner;

public class InputOutput12 {

    // 1023
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        Float floatNum = sc.nextFloat();
//        String str = String.valueOf(floatNum);

        Double doubleNum = sc.nextDouble();

        String str = String.valueOf(doubleNum);
        String[] arr = str.split("\\.");

        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        System.out.print(num1 +"\n" +num2);
    }
}