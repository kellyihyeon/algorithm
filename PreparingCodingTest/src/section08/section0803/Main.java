package section08.section0803;

import java.util.Scanner;

/**
 * 최대점수 구하기
 * 제한 시간 m 안에 n 개의 문제 중 최대점수를 얻도록 하라
 */
public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int answer = Integer.MIN_VALUE;

    // 역시 부분집합 문제. 시간을 기준으로 5점, 12점, 3점짜리 문제를 푼다면 10+25+6=41점 이런 식으로 20분이 될 수 있도록 조합한다.
    private void DFS(int level, int time, int sum) {
        // 레벨, 시간, 점수를 넘긴다.
        // 포함 하는 경우, 포함 하지 않는 경우의 수로 나눠서 타고 내려오면서 (포함하는 경우 합이 20이 넘는지 비교하면서) 합이 20을 넘으면 return 한다.
        if (time > m) {
            return;
        }

        // time 이 m 보다 작거나 같은 경우
        // 20이거나 20보다 작은 경우의 합을 기억하고, 모든 경우의 수를 계산 했을 때 최대값을 출력한다.
        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            // 1번부터 5번문제까지, 1번의 경우 걸리는 시간 -> 레벨1, 시간5 -> 레벨2, 시간 12... 레벨을 이용해 점수를 더해나가면 된다.(sum 계산)
            DFS(level + 1, time + arr[level + 1][1], sum + arr[level + 1][0]);    // 더하는 경우
            DFS(level + 1, time, sum);    // 더하지 않는 경우
        }
    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();  // 5개의 문제
        m = scanner.nextInt();  // 20분 안에 푼다.

        arr = new int[n + 1][2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        M.DFS(0, 0, 0);
        System.out.println(answer);
    }
}
