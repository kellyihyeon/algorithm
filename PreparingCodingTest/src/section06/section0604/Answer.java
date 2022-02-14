package section06.section0604;

import java.util.Scanner;

public class Answer {

    private int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) {
                // cache hit
                if (x == cache[i]) {
                    pos = i;
                }
            }
            // cache miss
            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }

            cache[0] = x;
        }
        return cache;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] task = new int[n];
        for (int i = 0; i < n; i++) {
            task[i] = scanner.nextInt();
        }

        for (int i : M.solution(s, n, task)) {
            System.out.print(i + " ");
        }
    }
}
