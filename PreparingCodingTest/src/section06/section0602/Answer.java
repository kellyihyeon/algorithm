package section06.section0602;

import java.util.Scanner;

/**
 * *** j < n - i - 1;
 * -> 루프 내의 j 조건이 핵심.
 * 버블 정렬은 인접한 두 수를 비교하면서 작은 수를 앞으로 내보내고 이를 반복하기 때문에 첫번째 반복이 끝나면 제일 큰 수가 맨 뒤에 있다.
 * 다음 번 루프에서 이를 반복할 때 두 번째로 큰 수는 뒤에서 두 번째에 위치한다.
 * 그렇기 때문에 j의 인덱스를 조정해서 j가 이미 정해진 수까지 비교할 필요 없게 해야한다.
 */
public class Answer {

    private int[] solution(int n, int[] arr) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int x : M.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
