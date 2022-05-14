package section09.section0908;

import sun.java2d.loops.ScaledBlit;

import java.util.*;

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

// 최소 스패닝 트리:
//  -> 1.크루스칼 알고리즘, 2.프림 알고리즘
public class Main {

    private static int solution(List<List<Edge>> graph, int n) {
        int answer = 0;

        int[] ch = new int[n + 1];

        Queue<Edge> pq = new PriorityQueue<>();
        // 시작점 지정: 1번 노드로 가는 비용 0
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();   // 시작: (1,0)
            int endVex = tmp.vex;
            if (ch[endVex] == 0) {  // 회로가 되는 걸 방지하기 위해
                ch[endVex] = 1;
                answer += tmp.cost;
                for (Edge ob : graph.get(endVex)) {
                    if (ch[ob.vex] == 0) {  // 양방향일 때, 다시 돌아가는 경우는 제외하기 위해서
                        pq.offer(new Edge(ob.vex, ob.cost));
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            // 양방향 ! 1 2 12, 2 1 12
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        System.out.println(solution(graph, n));
    }
}
