package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatedOutput1079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rawStrings = br.readLine().split(" ");

        for (String str : rawStrings) {
            System.out.println(str);
            if (str.equals("q")) {
                break;
            }
        }//for

    }

}
