package section09.section0901;

import java.util.*;

/**
 * 씨름 선수
 */
public class Main {


    private int solution(List<Person> list) {
        int answer = 0;

        list.sort((o1, o2) -> o2.height - o1.height);

        int max = Integer.MIN_VALUE;
        for (Person person : list) {
            if (person.weight > max) {
                max = person.weight;
                answer++;
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
            int height = scanner.nextInt();
            int weight = scanner.nextInt();

            list.add(new Person(height, weight));
        }

        System.out.println(M.solution(list));


    }
}


class Person {

    public int height;
    public int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}

