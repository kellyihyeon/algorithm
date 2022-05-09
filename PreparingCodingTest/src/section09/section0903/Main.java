package section09.section0903;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 결혼식
 */
public class Main {


    private int solution(List<Person> list) {
        int answer = Integer.MIN_VALUE;

        Collections.sort(list);

        int count = 0;
        for (Person person : list) {
            if (person.state.equals("start")) {
                count++;
            } else {
                count--;
            }

            if (count > answer) {
                answer = count;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        final Main M = new Main();
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();

            list.add(new Person(startTime, "start"));
            list.add(new Person(endTime, "end"));
        }
        System.out.println(M.solution(list));
    }
}


class Person implements Comparable<Person> {

    public int time;
    public String state;

    public Person(int time, String state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Person o) {
        if (this.time == o.time) {
            return this.state.compareTo(o.state);
        } else {
            return this.time - o.time;
        }
    }

}