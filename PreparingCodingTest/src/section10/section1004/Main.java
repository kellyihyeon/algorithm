package section10.section1004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    public int size;
    public int height;
    public int weight;

    public Brick(int size, int height, int weight) {
        this.size = size;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return o.size - this.size;
    }
}

public class Main {

    public static int[] dy;


    private int solution(List<Brick> list) {
        int answer = 0;

        Collections.sort(list);
        dy[0] = list.get(0).height;
        answer = dy[0];     //최상단에 있는 벽돌의 높이

        for (int i = 1; i < list.size(); i++) {
            int maxHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).weight > list.get(i).weight && dy[j] > maxHeight) {
                    maxHeight = dy[j];
                }
            }
            dy[i] = maxHeight + list.get(i).height;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Brick> list = new ArrayList<>();
        dy = new int[n];

        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            int height = scanner.nextInt();
            int weight = scanner.nextInt();

            list.add(new Brick(size, height, weight));
        }

        System.out.println(M.solution(list));
    }
}
