package section05.section0506;

import java.util.*;

// Queue 라는 자료구조를 사용하는 것
//      ──────────────────
//  ─────>               ─────>     First In First Out !
//      ───────────────────
// 주요 메서드: poll(), offer(), peek(), contains(), size()
public class Answer {

    private int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(M.solution(n, k));
    }
}
