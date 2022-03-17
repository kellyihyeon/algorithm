package section06.section0609;

import java.util.Scanner;

/**
 * 결정 알고리즘
 * lt ~ rt 사이에 내가 찾는 답이 무조건 있을 때 사용.
 */
public class Main {


    private int solution(int n, int m, int[] arr) {
        int answer = 0;

        int lt = Integer.MIN_VALUE;
        int rt = 0;

        for (int i : arr) {
            rt += i;
            if (lt < i) {
                lt = i;
            }
        }


        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            int count = 1;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > mid) {
                    count++;
                    sum = arr[i];
                }
            }

            if (count <= m) {
                answer = mid;
                rt = mid -1;
            } else {
                lt = mid + 1;
            }

        }

        return answer;
    }


    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n, m, arr));
    }
}
