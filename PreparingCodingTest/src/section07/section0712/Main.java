package section07.section0712;

import java.util.Scanner;

/**
 * 경로 탐색(인접 행렬)
 * 1번 정점에서 N번 정점으로 가는 모든 경로의 가지수 출력
 */
public class Main {

    private static int n = 0;
    private static int m = 0;
    private static int answer = 0;

    private static int[][] graph;
    private static int[] check;


    // DFS 로 풀기
    // 스택에 넣어서 DFS 대입하기
    private void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i < n + 1; i++) {
                if (graph[v][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new int[n + 1][n + 1];  // 5*5 그래프에 체크하기
        check = new int[n + 1];   // [0| 0 0 0 0 0]

        for (int i = 0; i < m; i++) {   // 0,1,2,3,4,5,6,7,8
            int a = scanner.nextInt(); // 1
            int b = scanner.nextInt(); // 2
            graph[a][b] = 1;
        }
        // 시작 노드에 체크
        check[1] = 1;
        M.DFS(1);

        System.out.println(answer);

    }
}
