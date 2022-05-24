package section10.section1006;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Problem {
    public int score;
    public int time;

    public Problem(int score, int time) {
        this.score = score;
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }
}


public class Main {

    private int solution(int m, List<Problem> list) {
        int[] dy = new int[m + 1];

        for (Problem problem : list) {
            final int score = problem.getScore();
            final int time = problem.getTime();

            for (int j = m; j >= time; j--) {
                dy[j] = Math.max(dy[j], dy[j - time] + score);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Problem> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int score = scanner.nextInt();
            int time = scanner.nextInt();

            list.add(new Problem(score, time));
        }

        System.out.println(M.solution(m, list));
    }

}
