package section02.section0208;

import java.util.Scanner;

public class Main {

    private static int[] solution(int n, int[] arr) {
        int rank = n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            rank = n;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arr[i] >= arr[j]) {
                        //System.out.println("arr[i] = " + arr[i] + ", arr[j] = " + arr[j]);
                        rank--;
                    }
                }
            }
            result[i] = rank;
        }
        return result;
    }

    private static int[] answer(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int rank : solution(n, arr)) {
            System.out.print(rank + " ");
        }
    }
}
