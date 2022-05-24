package section10.section1006;

import java.util.Scanner;

public class Answer {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] dy = new int[m + 1];

        for (int i = 0; i < n; i++) {
            int score = scanner.nextInt();
            int time = scanner.nextInt();

            for (int j = m; j >= time; j--) {
                dy[j] = Math.max(dy[j], dy[j - time] + score);
            }
        }

        System.out.println(dy[m]);

    }
}
