package section08.section0808;

import java.util.*;

/**
 * 수열 추측하기
 */
public class Main {

    static int n;
    static int f;

    static int[] b;      // 메모이제이션
    static int[] p;      // 순열
    static int[] check;

    static int[][] dy = new int[35][35];
    static boolean flag = false;


    // 메모이제이션
    private int combination(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }

    private void DFS(int level, int sum) {
        if (flag) {
            return;
        }

        if (level == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                }
                flag = true;
            }


        } else {
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    p[level] = i;
                    DFS(level + 1, sum + (p[level] * b[level]));
                    check[i] = 0;
                }
            }
        }


    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        f = scanner.nextInt();

        b = new int[n];
        p = new int[n];

        check = new int[n + 1];

        for (int i = 0; i < n; i++) {
            b[i] = M.combination(n - 1, i);
        }

        M.DFS(0, 0);


    }

}
