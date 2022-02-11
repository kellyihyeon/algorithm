package section06.section0601;

import java.util.Scanner;

/**
 * n 개의 수가 주어질 때 오름차순으로 정렬하여 출력하라. (정렬 방법: 선택 정렬)
 */
public class Main {

    private int[] solution(int n, int[] arr) {
        // arr 의 길이만큼 for 문을 반복한다.
        // 이중 for 문 돌면 O(N^2) 인데 괜찮나
        int min = Integer.MAX_VALUE;
        int position = 0;
        for (int i = 0; i < n; i++) {
            // 인덱스 0 ~ n 까지: 최소값을 찾는다.
            // 인덱스 1 ~ n 까지: 최소값을 찾는다.
            // 인덱스 +1 해주면서 반복한다.
            for (int j = i; j < n; j++) {
                if (min > arr[j]) {
                    position = j;   // position=1
                    min = arr[j];   // min=5
                }
            }
            //                  최소값을 0번째에 놓고, 0번째에 있던 숫자는 최소값이 있던 자리로 보낸다.(자리 교환)
            //                  최소값을 1번째에 놓고, 1번째에 있던 숫자는 n 번째로 보낸다.
            arr[position] = arr[i];
            arr[i] = min;
            min = Integer.MAX_VALUE;    // *** min 을 다시 리셋 시켜줘야지. 빼먹으면 배열의 전체 최소값으로 가져감

        }

        return arr;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : M.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
