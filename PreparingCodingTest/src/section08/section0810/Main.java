package section08.section0810;

import java.util.Scanner;

/**
 * 미로 탐색(DFS)
 * 상하좌우 4방향
 */
public class Main {

    private static final int[] dx = {-1, 0, 1, 0};    // 행
    private static final int[] dy = {0, 1, 0, -1};    // 열
    private static int[][] board;
    static int answer = 0;


    private void DFS(int x, int y) {    // d(1,1)-i=1,28, d(1,2)
        if (x == 7 && y == 7) {
            answer++;
        } else {    // 12시 3시 6시 9시 방향
            for (int i = 0; i < 4; i++) {

                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 1 && nextX <= 7 && nextY >= 1 && nextY <= 7 && board[nextX][nextY] == 0) {
                    board[nextX][nextY] = 1;
                    DFS(nextX, nextY);
                    board[nextX][nextY] = 0;
                }
            }

        }
    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        board = new int[8][8];

        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        board[1][1] = 1;
        M.DFS(1, 1);
        System.out.println(answer);
    }
}
