package section04.section0402;

import java.util.HashMap;
import java.util.Scanner;

public class Answer {

    // map 은 하나만 사용하고 일치 여부는 map 의 value 값을 -1씩 감소시키는 방식
    private String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            } else {
                map.put(x, map.get(x) - 1);
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        System.out.println(M.solution(a,b));

    }
}
