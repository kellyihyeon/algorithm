package section05.section0507;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Answer {

    private String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char x : need.toCharArray()) {
            queue.offer(x);
        }

        for (char x : plan.toCharArray()) {
            if (queue.contains(x)) {
                if (x != queue.poll()) {
                    return "NO";
                }
            }
        }

        if (!queue.isEmpty()) {
            return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(M.solution(a, b));
    }
}
