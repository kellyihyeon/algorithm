package section08.section0802;

import java.util.Scanner;

/**
 * 바둑이 승차(DFS)
 * 바둑이들 무게를 합했을 때 가장 무겁게 채워서 데리고 탈 수 있게 하라.
 */
public class Main {
    static int weight;
    static int n;
    static int[] arr;
    static int sum = 0;
    static int answer = 0;

    // 부분집합처럼 풀어나가기. + 조건: 그 합이 주어진 weight 값을 넘어선 안되고, 더한 값 중에서는 제일 큰 값이어야 한다.
    // 0 [81 58 42 33 61]
    // sum 이 weight 를 넘지 않으면 다음 바둑이를 더한다. 81 + 58= 139, 139+42=181, 181+33=214, 214+61=275
    // 275 > 259 를 넘으면 빽해서 돌아온다. weight 를 넘지 않은 sum 은 214 -> 저장해 놓는다.
    // 이렇게 수를 더한 경우, 더하지 않은 경우의 sum 을 계산해 나가고 이 중 더 큰 sum 을 찾아야 한다.
    // 33바둑이를 빼고 61바둑이를 더하면? 242. -> sum 214와 242를 비교했을 때 더 큰 수가 정답이 된다.
    private void DFS(int index, int sum) {
        if (index == n) {
            if (sum < weight && sum > answer) {
                answer = sum;
            }
            return;
        }

        if (sum < weight) {
            DFS(index + 1, sum + arr[index + 1]);
            DFS(index + 1, sum);

        }

    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        weight = scanner.nextInt();
        n = scanner.nextInt();
        arr = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = scanner.nextInt();
        }

        M.DFS(0, sum);
        System.out.println(answer);
    }
}
