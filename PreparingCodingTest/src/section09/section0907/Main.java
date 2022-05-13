package section09.section0907;

import java.util.*;

class Edge implements Comparable<Edge> {
    public int v1;
    public int v2;
    public int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }

}

// 트리와 회로의 차이 !
public class Main {
    public static int[] unf;


    public static int Find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        unf = new int[n + 1];

        List<Edge> list = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            list.add(new Edge(a, b, c));
        }

        int answer = 0;
        Collections.sort(list);

        // 트리 만들기
        for (Edge ob : list) {  // cost 가 제일 적은 순서대로
            int findV1 = Find(ob.v1);
            int findV2 = Find(ob.v2);

            if (findV1 != findV2) { // 같은 집합이 아니라면
                answer += ob.cost;
                Union(ob.v1, ob.v2);    // 한 집합으로 묶기
            }

        }
        System.out.println(answer);
    }
}



