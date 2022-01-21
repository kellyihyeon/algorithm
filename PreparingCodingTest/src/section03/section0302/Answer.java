package section03.section0302;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Answer {

    private List<Integer> solution(int n, int m, int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        System.out.println("sort 메소드 실행 전 = "+ LocalDateTime.now());    // 2022-01-21T16:31:55.183
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println("sort 메소드 실행 후 = "+ LocalDateTime.now());    // 2022-01-21T16:31:55.186

        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) {
            if (a[p1] == b[p2]) {
                answer.add(a[p1]);
                p1++;
                p2++;
            } else if (a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Answer A = new Answer();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int x : A.solution(n, m, a, b)) {
            System.out.print(x + " ");
        }

    }
}
