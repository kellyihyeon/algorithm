package section07.section0708;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 송아지 찾기
 * 최소의 횟수를 구해라. 최소의 횟수로 ~를 구해라 = 최단 거리 구하기
 *
 * 레벨 0:                          5 (시작 위치)
 * 레벨 1:         6                4              10
 * 레벨 2:      7     11          3   9            15
 * 레벨 3:    8 12   10 16        2   14           20
 *
 * 중복된 수는 담지 않는다.
 * target: 14
 * 최단거리 : 3
 *
 */
public class Main {

    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] check;
    Queue<Integer> queue = new LinkedList<>();

    private int BFS(int s, int e) { // s=5, e=14
        // 직선의 좌표 점은 1부터 10,000까지
        check = new int[10001];
        check[s] = 1;   // 현수의 현 위치를 1로 체크
        queue.offer(s);

        int level = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                int node = queue.poll();

                for (int j = 0; j < 3; j++) {
                    int childNode = node + dis[j];

                    if (childNode == e) {
                        return level + 1;
                    }

                    if (childNode >= 1 && childNode <= 10000 && check[childNode] == 0) {
                        check[childNode] = 1;
                        queue.offer(childNode);
                    }
                }
            }
            level++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int e = scanner.nextInt();

        System.out.println(M.BFS(s, e));
    }
}
