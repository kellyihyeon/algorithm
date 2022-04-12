package section08.section0803;

import java.util.Scanner;

public class Answer {
    static int answer = Integer.MIN_VALUE;
    static int n;
    static int m;


    /**
     * @param level
     * @param sum
     * @param time
     * @param ps    problem score
     * @param pt    problem time
     */
    private void DFS(int level, int sum, int time, int[] ps, int[] pt) {
        if (time > m) {
            return;
        }

        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(level + 1, sum + ps[level], time + pt[level], ps, pt);
            DFS(level + 1, sum, time, ps, pt);
        }
    }

    public static void main(String[] args) {
        final Answer A = new Answer();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        // 배열 2개로 해결.
        int[] a = new int[n];   // 점수
        int[] b = new int[n];   // 시간

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        A.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }
}
