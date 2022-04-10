package section07.section0714;

import java.util.*;

/**
 * 그래프 최단거리(BFS)
 * 1번 정점에서 각 정점으로 가는 최소 이동 간선수 출력
 */
public class Main {

    static int n;
    static int m;

    static List<List<Integer>> graph;
    static int[] check;
    static int[] distance;

    // 최소 이동 간선수 = 레벨을 확인할 것
    // 정점 6, 간선 9
    // check, distance(기존 레벨 +1), queue 활용 !

    private void BFS(int v) {   // b(1)
        Queue<Integer> queue = new LinkedList<>();
        check[v] = 1;       // check = [1 1 1 1 1 1]
        distance[v] = 0;    // dis = [0 3 1 1 2 2]
        queue.offer(v);     // queue = 1 3 5 6 2[ ]

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            //0-    1
            //1- 3     4
            //2-     5   6
            //3-         2
            for (Integer nv : graph.get(currentVertex)) {
                if (check[nv] == 0) {
                    check[nv] = 1;
                    queue.offer(nv);
                    distance[nv] = distance[currentVertex] + 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());   // 0 1 2 3 4 5 6
        }

        check = new int[n + 1];
        distance = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }
        M.BFS(1);

        for (int i = 2; i < distance.length; i++) {
            System.out.print(i + " : " + distance[i]);
            System.out.println();
        }


    }
}
