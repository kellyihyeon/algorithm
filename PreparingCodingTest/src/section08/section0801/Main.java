package section08.section0801;

import java.util.Scanner;

/**
 * 합이 같은 부분집합(DFS: 아마존 인터뷰)
 * 서로소 집합: 공통 원소가 없는 두 집합
 */
public class Main {
    static String answer = "NO";
    static int n = 0;
    static int total = 0;
    boolean flag = false;


    // 집합을 어떻게 두 부분으로 나눠야 할지부터 막힘
    private void DFS(int level, int sum, int[] arr) {  // d(0, 0, arr)-32, d(1,1)-32, d(2,4)-32, d(3,9)-32, d(4,15)-32, d(5,15)-34, d(6, 25)-33
        // arr = [1 3 5 6 7 10] 1 4 9 15 22 32
        if (flag) {
            return;
        }
        if (sum > total / 2) {
            return;
        }

        if (level == n) {   // n=6
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            // 부분집합 구하기
            DFS(level + 1, sum + arr[level], arr);  // 더하는 경우
            DFS(level + 1, sum, arr);                   // 더하지 않는 경우
        }

    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }

        M.DFS(0, 0, arr);
        System.out.println(answer);

    }
}
