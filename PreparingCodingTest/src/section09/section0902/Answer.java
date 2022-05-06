package section09.section0902;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Time implements Comparable<Time> {

    public int startTime;
    public int endTime;

    public Time(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Time o) {
        if (this.endTime == o.endTime) {
            return this.startTime - o.startTime;
        } else {
            return this.endTime - o.endTime;
        }

    }
}

public class Answer {

    private int solution(List<Time> list, int n) {
        int cnt = 0;

        Collections.sort(list);
        int et = 0;
        for (Time ob : list) {
            if (ob.startTime >= et) {
                cnt++;
                et = ob.endTime;
            }
        }


        return cnt;
    }


    public static void main(String[] args) {
        final Answer M = new Answer();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            list.add(new Time(start, end));
        }

        System.out.println(M.solution(list, n));
    }
}
