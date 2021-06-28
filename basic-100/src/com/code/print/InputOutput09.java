package com.code.print;

import java.util.Scanner;

public class InputOutput09 {

    // 1020
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split("-");

        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);
        System.out.printf("%06d%07d", num1, num2);
    }
}