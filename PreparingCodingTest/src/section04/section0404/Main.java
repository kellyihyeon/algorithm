package section04.section0404;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private int solution(String s, String t) {
        // s 문자열과 t 문자열이 주어질 때 t 문자열과 아나그램이 되는 s 문자열의 갯수를 구하라. (대소문자 구분)
        int answer = 0;
        // map 의 모든 values 를 한번에 같은 값으로 설정하는 방법을 모르므로 map 2개를 사용한다.
        // bacaAacba
        // abc
        // 슬라이딩 윈도우를 해야하는데 각각 비교가 안돼서 문제가 안풀린다. -> 한번만 비교하면 된다고 가정하고 풀어보자.
        // s = bac
        // t = abc 가 아나그램인가?
        // t를 맵에 담는다. map - value = 1 1 1 -> s 를 하나씩 넣고 -1 해본다.

        // map 세팅
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 출력
        for (Character character : map.keySet()) {
            System.out.println(character + " = " + map.get(character));
        }

        // 초기 세팅
        // ba - abc : 1 1 1 -> 0 0' 1, true
        // Za - abc : 1 1 1 -> 0 1' 1, false -> map 에 없는 밸류가 존재하면 0이든 -1이든 숫자는 상관없으므로 boolean 을 이용해야 되려나?
        boolean check = true;   // 한 번이라도 걸리면 false 를 유지하게끔 해야되므로 디폴트는 true.
        for (int i = 0; i < t.length() - 1; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else {
                check = false;
            }
        }

        // rt 세팅
        // baZaAacba
        // abc 로
        int lt = 0;
        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            if (map.containsKey(s.charAt(rt))) {
                map.put(t.charAt(rt), map.get(t.charAt(rt)) - 1);   // 0 0 0, true
                if (check && map.get(t.charAt(rt)) == 0) {
                    answer++;
                }
            }
            // rt든 lt든 map 에 포함되어 있지 않으면 전후로 아나그램이 아니기 때문에 건너뛰면 되는데 -> rt 를 훅 건너뛰게 해서 타겟+1 지점부터 다시 하면 된다.
            map.put(s.charAt(rt), map.get(s.charAt(rt)) + 1);
        }



        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        System.out.println(M.solution(s,t));
    }
}
