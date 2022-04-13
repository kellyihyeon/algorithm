package section08.section0805;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Answer {
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;

    private void DFS(int level, int sum, Integer[] arr) {
        if (sum > m) {
            return;
        }
        if (level >= answer) {
            return;
        }

        if (sum == m) {
            answer = Math.min(answer, level);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(level + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        final Answer A = new Answer();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        m = scanner.nextInt();
        A.DFS(0, 0, arr);
        System.out.println(answer);

    }
}
