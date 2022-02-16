package section06.section0606;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Answer {

    // tmp 에 arr 을 복사해놓고 tmp 를 정렬한다.
    // arr 과 tmp 원소가 다른 위치를 찾는다. 철수와 짝꿍이 자리를 바꿨으니 원소가 같지 않은 지점이 둘의 위치이다.
    private List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                answer.add(i+1);
            }
        }

        return answer;
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
