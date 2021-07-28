package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDimensionalArray1096 {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[19][19];

            for (int i = 0; i < n; i++) {
                String[] raw = br.readLine().split(" ");    // raw = 1, 1
                int first = Integer.parseInt(raw[0]);
                int second = Integer.parseInt(raw[1]);
                board[first-1][second-1] = 1;
            }

            for (int i = 0; i < board.length; i++) {    // 1 ~ 19
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
