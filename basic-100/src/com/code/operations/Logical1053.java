package com.code.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logical1053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(br.readLine());
        if (i == 1) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
