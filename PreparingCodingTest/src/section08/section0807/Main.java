package section08.section0807;

import java.util.Scanner;

/**
 * 조합의 경우 수 (메모이제이션)
 *
 */
public class Main {

    static int[][] arr;

    // 5C3 = 4C2 + 4C3
    // 4C2 = 3C1 + 3C2
    // 3C1 = 2C0 + 2C1  ...
    private int DFS(int n, int r) {
        // r = 0 이면 1을 반환한다.
        // n = r 이면 1을 반환한다.
        if (r == 0 || n == r) {
            return 1;
        } else {
            // 그리고 메모이제이션을 활용해, 계산 된 배열의 결과값을 이용하도록 한다.
            if (arr[n][r] != 0) {
                return arr[n][r];
            } else {    // arr 이 초기화인 상태 (0인 상태)
                return arr[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
            }
        }

    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        arr = new int[n + 1][r + 1];

        System.out.println(M.DFS(n, r));

    }
}
