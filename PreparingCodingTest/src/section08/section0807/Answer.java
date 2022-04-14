package section08.section0807;

import java.util.Scanner;

public class Answer {

    int[][] dy = new int[35][35];


    private int DFS(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Answer A = new Answer();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        System.out.println(A.DFS(n, r));
    }
}
