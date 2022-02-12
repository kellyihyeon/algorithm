package section06.section0602;

import java.util.Scanner;

/**
 * n 개의 숫자가 입력되면 오름차순으로 정렬하라. (정렬 방법: 버블 정렬)
 * 인접한 수와 비교해서 정렬을 마치고, 다음 인덱스로 넘어가서 또 다시 인접한 수와 비교해서 정렬을 한다.
 * 전체 수가 정렬이 될 때까지 반복한다.
 *
 * *** 놓친 점: 버블 정렬의 특징으로 인한 규칙을 찾지 못함.
 */
public class Main {

    private int[] solution(int n, int[] arr) {
        // i는 0으로 계속 고정 되어있어야 한다.
        // 1차: a 가 0일 때, b 는 1이다. 0과 1을 비교하고 정렬한다. 1과 2를 비교하고 정렬한다. 2와 3을 비교 정렬. 3과 4를 비교 정렬. 4와 5를 비교 정렬.
        // 2차:                        0과 1 비교 정렬. 1과 2 비교 정렬 -> 반복.
        // i 는 반복하는 횟수로 이용하고, position = 0부터 ++ 해나간다. (0부터 4) j는 position+1부터 n-1까지(1부터 5) ++ 하고 다음 i 가 시작될 때 position은 0으로 리셋
        int tmp = 0;
        for (int i = 0; i < n - 1; i++) {
            int position = 0;

            for (int j = position + 1; j < n; j++) {
                if (arr[position] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[position];
                    arr[position] = tmp;
                }
                position++;
            }
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
