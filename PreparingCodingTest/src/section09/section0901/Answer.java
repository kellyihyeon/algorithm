package section09.section0901;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 내가 푼 것보다 시간이 절반밖에 안 걸림
 */

class Body implements Comparable<Body> {

    public int h;
    public int w;


    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}


public class Answer {

    public int solution(List<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);

        int max = Integer.MIN_VALUE;
        for (Body ob : arr) {
            if (ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        final Answer M = new Answer();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();

            arr.add(new Body(h, w));
        }

        System.out.println(M.solution(arr, n));

    }
}
