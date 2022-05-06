package section09.section0902;

import java.util.*;

/**
 * 회의실 배정
 * 정렬할 기준을 잘 잡을 것!
 */
public class Main {


    private int solution(List<Time> list, int n) {
        int answer = 1;

        Collections.sort(list);

        int time = list.get(0).endTime;

        for (int i = 1; i < n; i++) {
            if (list.get(i).startTime >= time) {
                time = list.get(i).endTime;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        final Main M = new Main();
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

class Meeting implements Comparable<Time> {

    public int startTime;
    public int endTime;

    public Meeting(int startTime, int endTime) {
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
