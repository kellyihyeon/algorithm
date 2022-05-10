package section09.section0904;

import java.util.*;

/**
 * 최대 수입 스케쥴 -> 무슨 말인지 모르겠다.
 */
public class Main {

    private static int n;
    private static int max = Integer.MIN_VALUE;

    //60 3
    //30 3
    //50 2
    //40 2
    //20 1
    //30 1
    private int solution(List<Lecture> list) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);

        int j = 0;
        for (int i = max; i >= 1; i--) {    // i=3,2,1
            // ???
            for (; j < n; j++) {   // j=0,1,2,3,4,5
                if (list.get(j).due < i) {
                    break;
                }
                pq.offer(list.get(j).pay);  //60,30,
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        List<Lecture> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pay = scanner.nextInt();
            int due = scanner.nextInt();
            max = Math.max(max, due);

            list.add(new Lecture(pay, due));
        }

        System.out.println(M.solution(list));


    }

}

class Lecture implements Comparable<Lecture> {
    public int pay;
    public int due;

    public Lecture(int pay, int due) {
        this.pay = pay;
        this.due = due;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.due - this.due;
    }
}
