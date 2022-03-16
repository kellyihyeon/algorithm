package section06.section0608;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이분 검색
 * 첫 줄에 n과 m이 주어진다.
 * n 은 임의의 n개의 수를 의미하고, m은 n개의 수 중 하나를 의미한다.
 * n 개의 수를 오름차순으로 정렬하고, m이 정렬된 상태에서 몇 번째에 있는지 구하라. (이분 검색 이용)
 */
public class Main {

    private int solution(int n, int target, int[] arr) {
        // 오름차순으로 먼저 정렬하자.
        // left, right, middle 포인터를 이용해서 탐색 범위를 좁히자.
        Arrays.sort(arr);

        int answer = 0;
        int left = 0;
        int right = n - 1;
        int middle = 0;

        while (left <= right) {
            middle = (left + right) / 2;
            if (arr[middle] < target) {
                left = middle + 1;

            } else if (arr[middle] == target) {
                answer = middle + 1;
                return answer;

            } else {
                right = middle - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 입력 받아야 할 수를 전부 입력 받는다.
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n,m,arr));

    }
}
