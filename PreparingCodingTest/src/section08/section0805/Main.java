package section08.section0805;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 동전 교환
 * 거슬러 줄 동전의 최소개수를 출력하라.
 * Time Limit Exceeded -> 고침
 */
public class Main {
    static int n;
    static Integer[] arr;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static int sum;



    // 0에서 나눠 줄 수 있는 동전 갯수만큼 for 문을 돌린다.
    // lv0-       0
    // lv1-    1        2       5   1원을 처음에 포함했을 때 나머지 필요한 동전을 또 구한다.
    // lv2-   1  2  5   (동전을 더해가면서 거슬러줘야 할 돈과 같은지 비교한다.)
    // lv3- 1          (동전 합 sum 과 m 이 같을 때, level 을 출력해야하는데,가장 작은 level 값을 구해서 출력한다.)
    private void DFS(int level, int sum) {
        if (sum > m) {
            return;
        }

        if (sum == m) {
            answer = Math.min(answer, level);   // 4, 76, 2
        } else {
            // Time Limit Exceeded (2) *** 과정 중 answer 가 7이 나왔을 때, 7이상 넘어가는 level 은 볼 필요가 없다.
            if (level < answer) {
                for (int i = 0; i < n; i++) {
                    DFS(level + 1, sum + arr[i]);
                }

            }
        }


    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        // 동전 종류의 갯수 n
        n = scanner.nextInt();

        // n개의 동전의 종류
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        // Time Limit Exceeded (1) *** 최소 동전 갯수를 구하므로 동전 액수가 큰 것부터 계산
        Arrays.sort(arr, Collections.reverseOrder());

        // 거슬러 줄 금액 m
        m = scanner.nextInt();
        sum = 0;

        M.DFS(0, sum);
        System.out.println(answer);

    }
}
