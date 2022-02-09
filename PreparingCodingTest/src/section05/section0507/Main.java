package section05.section0507;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 필수 과목 requiredSubject 가 순서대로 주어지고, 수업 설계 subjectPlan 이 주어진다.
// 필수 과목은 반드시 주어진 순서대로 이수해야 한다. 필수 과목 이수 조건에 맞게 수업 설계가 계획 됐다면 YES, 그렇지 않으면 NO 를 출력하라.
public class Main {

    // 필수 과목 문자열을 queue 에 담는 방법
    // ** 설계 과목의 문자들을 하나씩 빼서 비교할 것이므로 for each 문 사용했으면 깔끔
    private String solution2(String requiredSubject, String subjectPlan) {
        String answer = "YES";

        // 필수 과목을 queue 에 넣고,
        Queue<Character> queue = new LinkedList<>();
        for (char c : requiredSubject.toCharArray()) {
            queue.offer(c);
        }

        // 수업 설계 길이만큼 설계한 과목이 queue 에 있는지 본다.
        for (int i = 0; i < subjectPlan.length(); i++) {
            // 1.있다. 2.없다.
            //  1. 있으면 그 과목과 필수 과목의 첫번째 과목이 같은지 확인한다. -> 1.같다. 2.다르다.
            if (queue.contains(subjectPlan.charAt(i))) {
                //          1. 같으면 queue 에서 없앤다. 순서가 맞으니까.(poll 하면 없어지니까 로직을 짤 필요는 없다.)
                //          2. 다르다면, 필수 과목의 순서와 설계한 과목의 순서가 맞지 않으므로 NO를 return 한다.
                if (queue.poll() != subjectPlan.charAt(i)) {
                    return "NO";
                }
            }
            //  2. 없으면 필수 과목이 아니라는 의미이므로 상관없다. 그냥 넘어간다. (로직을 짤 필요가 없다.)
        }

        // 필수 과목 queue 가 비어져있지 않으면 필수 과목을 전부 넣어서 설계를 한 것이 아니기 때문에 NO를 출력한다.
        if (queue.size() != 0) {
            return "NO";
        }

        return answer;
    }

    // 수업 설계 문자열을 queue 에 담는 방법
    private String solution(String requiredSubject, String subjectPlan) {
        String answer = "YES";
        // 우선 수업 설계 문자열을 queue 에 하나씩 담아 놓는다.
        Queue<Character> queue = new LinkedList<>();
        for (char c : subjectPlan.toCharArray()) {
            queue.add(c);
        }
        // *** queue = 설계한 과목
        // 언제까지 해야 하는가? 수업 설계 길이가 필수 과목의 길이와 같을 수도 있잖아. -> 필수 과목 길이와 수업 설계 길이가 같다면 ? 멈추면 된다.
        while (requiredSubject.length() != queue.size()) {
            // 설계 길이가 30일 경우: 시간? -> O(N) -> 설계 길이를 돌리면 길이가 30개라 시간이 기니까 필수 과목을 손대보자.
            // 필수과목이 포함돼있느냐로 로직을 줄여보자.
            for (int i = 0; i < requiredSubject.length(); i++) {
                if (!queue.contains(requiredSubject.charAt(i))) {
                    return "NO";
                }
            }
            // 설계한 과목을 순서대로 필수 과목과 비교한다. 설계 과목 첫 번째가 필수 과목에 포함이 되는지 확인한다.
            if (requiredSubject.contains(String.valueOf(queue.peek()))) {
                // 필수 과목에 포함된다면? 삭제한다. 그리고 삭제한 문자를 queue 맨 뒤에 추가해 놓는다. subjectPlan = C B A
                queue.offer(queue.poll());
            } else {
                // 필수 과목에 포함되지 않으면 삭제한다.
                queue.poll();
            }
        }
        // 멈추고 둘의 문자열이 같은지 비교한다.
        for (int i = 0; i < requiredSubject.length(); i++) {
            // 순서가 중요하다. 순서가 하나라도 맞지 않다면 NO 를 출력한다.
            if (requiredSubject.charAt(i) != queue.poll()) {
                return "NO";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        String requiredSubject = scanner.nextLine();
        String subjectPlan = scanner.nextLine();
        System.out.println(M.solution(requiredSubject, subjectPlan));

    }
}
