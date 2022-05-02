package section08.section0813;

import java.util.Scanner;

/**
 * 섬나라 아일랜드(DFS)
 */
public class Main {

    private static int answer = 0;
    private static int n;

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private static int[][] board;

    // 섬의 좌표
    private static void DFS(int x, int y) {
        for (int k = 0; k < 8; k++) {
            int nextX = x + dx[k];
            int nextY = y + dy[k];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && board[nextX][nextY] == 1) {
                board[nextX][nextY] = 0;
                DFS(nextX, nextY);
            }
        }
    }

    private static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;      // 출발점을 0으로 바꾸기
                    DFS(i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        M.solution();
        System.out.println(answer);

    }
}
