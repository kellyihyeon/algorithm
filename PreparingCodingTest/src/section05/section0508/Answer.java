package section05.section0508;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id=id;
        this.priority=priority;
    }
}

class Answer {

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(new Person(i, arr[i]));
        }

        while (!q.isEmpty()) {
            Person tmp = q.poll();
            for (Person x : q) {
                if (x.priority > tmp.priority) {
                    q.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n, m, arr));

    }

}
