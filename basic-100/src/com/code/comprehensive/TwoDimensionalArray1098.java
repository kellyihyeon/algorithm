package com.code.comprehensive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 격자판의 세로(h), 가로(w), 막대의 개수(n), 각 막대의 길이(l),
 * 막대를 놓는 방향(d:가로는 0, 세로는 1)과
 * 막대를 놓는 막대의 가장 왼쪽 또는 위쪽의 위치(x, y)가 주어질 때,
 *
 * 격자판을 채운 막대의 모양을 출력하는 프로그램을 만들어보자.
 */
public class TwoDimensionalArray1098 {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            // 5 5 격자판의 세로 h, 가로 w
            final String[] firstRaw = br.readLine().split(" ");
            final int h = Integer.parseInt(firstRaw[0]);
            final int w = Integer.parseInt(firstRaw[1]);

            int[][] board = new int[h+1][w+1];
            final int l = Integer.parseInt(br.readLine());
            // 2 0 1 1  -> 막대 길이 l, 방향 d, 좌표 x, y
            // 3 1 2 3
            // 4 1 2 5
            int[][] barRepo = new int[l][4];
            // 분류작업
            for (int i = 0; i < l; i++) {
                final String[] barInfoRaw = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    final int scanNum = Integer.parseInt(barInfoRaw[j]);
                    barRepo[i][j] = scanNum;
                }
            }
            // 막대 방향: arr[][]
            // 가로는 0, 세로는 1
            // 막대 위치: 좌표 x,y
            // 막대가 놓인 자리는 1, 아닌 자리는 0
            // 2, 0, 1, 1
            for (int i = 0; i < l; i++) {   // i = 0, 1, 2
                for (int j = 0; j < 4; j++) {   // j = 1, 2, 3, 4
                    final int barLength = barRepo[i][0];    // j-1
                    final int direction = barRepo[i][1];
                    final int x = barRepo[i][2];    // 1
                    final int y = barRepo[i][3];    // 1

                    // 같은 코드 1: 메모리 11832, 시간 70
                    switch (direction){
                        case 0:
                            for (int k = 0; k < barLength; k++) { // k = 0, 1
                                board[x][y + k] = 1;    // 시작점: 1,1 부터
                            }
                            break;

                        case 1:
                            for (int k = 0; k < barLength; k++) {   // 3, 1, 2, 3
                                board[x+k][y] = 1;
                            }
                            break;
                    }


                    // 같은 코드 2: 메모리 11824, 시간 73
                    if (direction == 0) {   // 막대 방향 = 가로
                        for (int k = 0; k < barLength; k++) {
                            board[x][y + k] = 1;
                        }
                    } else {    // 막대 방향 = 세로
                        for (int k = 0; k < barLength; k++) {
                            board[x+k][y] = 1;
                        }
                    }

                    // 같은 코드 3: 메모리 11824, 시간 67
                    for (int k = 0; k < barLength; k++) {
                        if (direction == 0) {
                            board[x][y + k] = 1;
                        } else {
                            board[x+k][y] = 1;
                        }
                    }
                }
            }

            // 헷갈리니까 격자판 인덱스 위치 기준으로 시작하자
            for (int i = 1; i < h + 1; i++) { // w 가로, h 세로 / 6, 6
                for (int j = 1; j < w + 1; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
