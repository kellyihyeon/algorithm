package section03.section0304;

import java.util.Scanner;

// 재도전 문제
public class Main {

    // 이중 for 문으로 푸는 거 말고는 도저히 설계 자체가 안됨.
    // two pointers 로 푸는 건 position1 = 첫번째 인덱스, position2 = 마지막 인덱스(합계가 m을 넘었을 때 인덱스) 이렇게 푸는 건데
    // 이렇게 풀면 두 번째 부터는 position1 인덱스 값을 어떻게 알아낼 수 있는지 몰라서 못했음
    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;

        int position1 = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == m) {
                answer++;
            }
            while (sum >= m) {
                sum -= arr[position1];
                position1++;
                if (sum == m) {
                    answer++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        // 정수 n과 m이 주어진다. n개의 수로 이루어진 수열에서 연속부분수열 합이 m이 되는 경우가 몇 번 있는지 출력하라.
        Main M = new Main();
        Scanner scanner= new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(M.solution(n, m, arr));

    }

}
