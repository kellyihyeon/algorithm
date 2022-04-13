package section08.section0806;

import java.util.Scanner;

public class Answer {
    static int[] pm;
    static int[] check;
    static int[] arr;

    static int n;
    static int m;


    private void DFS(int level) {
        if (level == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    pm[level] = arr[i];
                    DFS(level + 1);
                    check[i] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        final Answer A = new Answer();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        check = new int[n];
        pm = new int[m];

        A.DFS(0);

    }
}
