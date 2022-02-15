package section06.section0605;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * n 명의 학생이 각자 좋아하는 수를 적어낸다. (수의 범위: 1부터 10,000,000까지의 자연수)
 * 적어낸 숫자 중 중복된 수가 존재하면 D, 그렇지 않으면 U 를 출력하라.
 */
public class Main {

    // 이렇게 간단하게 풀리는 문제가 아닐텐데...
    private String solution(int n, int[] arr) {
        String answer = "U";
        // 같은 수가 있는지 없는지는 배열의 원소를 일일이 뒤져봐야 알 수 있다. 규칙이 없다.
        // 그렇다고 이중 for 문 돌리면서 정말로 N2 으로 하기엔 시간복잡도가 크다. (640ms 나옴)
        // 정렬할 필요없이 인덱스 범위를 줄여서 검사하지 않은 뒷 배열들 범위만 줄이면 되겠다.
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return "D";
                }
            }
        }
        return answer;
    }

    // O(N)
    private String solutionUsingHashMap(int n, int[] arr) {
        String answer = "U";
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            if (map.get(arr[i]) > 1) {
                return "D";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n, arr));
//        System.out.println(M.solutionUsingHashMap(n, arr));
    }
}
