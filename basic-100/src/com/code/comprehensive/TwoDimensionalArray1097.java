package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDimensionalArray1097 {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int[][] board = new int[20][20];
            int cnt = 0;

            for (int i = 1; i < 20; i++) {
                String[] raw = br.readLine().split(" ");
                for (int j = 0; j < 19; j++) {
                    board[i][j+1] = Integer.parseInt(raw[j]);
                }
            }

            int n = Integer.parseInt(br.readLine());   // 2

            for (int i = 0; i < n; i++) {
                String[] raw  = br.readLine().split(" ");   // 10, 10
                int x = Integer.parseInt(raw[0]);   // 10
                int y = Integer.parseInt(raw[1]);   // 10

                // board[x][1 ~ 19] x
                // board[1 ~ 19][y] y
                for (int j = 1; j < 20; j++) {
                    if (board[x][j] == 0) {
                        board[x][j] = 1;
                    } else {
                        board[x][j] = 0;
                    }

                    if (board[j][y] == 0) {
                        board[j][y] = 1;
                    } else {
                        board[j][y] = 0;
                    }
                }
            }//for

            // result
            for (int i = 1; i < 20; i++) {
                for (int j = 1; j < 20; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
