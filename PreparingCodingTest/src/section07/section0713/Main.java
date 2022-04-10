package section07.section0713;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 경로 탐색(인접 리스트)
 * 1번 정점에서 N번 정점으로 가는 모든 경로의 가지수 출력
 * N이 10,000이라면 인접행렬은 10,000 * 10,000번 돌아야한다.
 */
public class Main {
    private static int n;
    private static int m;
    private static List<List<Integer>> graph;
    private static int[] ch;
    private static int answer;

    private void DFS(int v) {
        // list -> list<integer>
        // 1->2,3,4
        // 2->1,3,5
        // 3->4
        // 4->2,5
        // list [1{2,5}, 2{3,4}, 3{4,5} 4 5]
        if (v == n) {
            answer++;   //12345,125,13425,1345,1425,145
        } else {
            for (Integer nv : graph.get(v)) {
                if (ch[nv] == 0) {  // ch 0[1 0 0 1 1]
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());   // graph = 0[1,2,3,4,5]
        }

        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }

        ch[1] = 1;
        M.DFS(1);
        System.out.println(answer);




    }
}
