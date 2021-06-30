package com.code.print;

import java.util.Scanner;

public class InputOutput14 {

    // 1025
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String str = String.valueOf(num);

        int arr[] = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {    //7 5 2 5 4
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        int[] numArr = new int[5];
        numArr[0] = arr[0] * 10000;
        numArr[1] = arr[1] * 1000;
        numArr[2] = arr[2] * 100;
        numArr[3] = arr[3] * 10;
        numArr[4] = arr[4];

        for (int i = 0; i < 5; i++) {
            System.out.println("[" + numArr[i] + "]");
        }

        // 다른 사람 코드
//        String s;
//        Scanner sc = new Scanner(System.in);
//        s=sc.next();
//
//        int [] data = new int[s.length()];
//
//        for(int i=0; i<s.length(); i++) {
//            data[i]=s.charAt(i)-'0';
//
//        }
//
//        System.out.println("["+data[0]*10000+"]");
//        System.out.println("["+data[1]*1000+"]");
//        System.out.println("["+data[2]*100+"]");
//        System.out.println("["+data[3]*10+"]");
//        System.out.println("["+data[4]+"]");

    } //main
}