package section08.section0815;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 도시의 피자 배달 거리(DFS)
 */
public class Main {

    private static int n;
    private static int m;
    private static int length;
    private static int answer = Integer.MAX_VALUE;

    private static int[] combi;     // 조합 저장 (length C m)

    private static List<Point> house;     // 집의 좌표
    private static List<Point> pizza;     // 피자집의 좌표


    private void DFS(int level, int s) {
        if (level == m) {
            int sum = 0;    // 도시의 피자배달 거리

            for (Point h : house) {
                int distance = Integer.MAX_VALUE;
                for (int i : combi) {   // 살아남은 피자 집
                    distance = Math.min(distance, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
                }
                sum += distance;
            }
            answer = Math.min(answer, sum);

        } else {
            for (int i = s; i < length; i++) {
                combi[level] = i;   // i = 0 ~ length
                DFS(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        pizza = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = scanner.nextInt();
                if (tmp == 1) {
                    house.add(new Point(i, j));
                } else if (tmp == 2) {
                    pizza.add(new Point(i, j));
                }
            }
        }

        length = pizza.size();

        combi = new int[m];
        M.DFS(0, 0);
        System.out.println(answer);



    }
}

class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
