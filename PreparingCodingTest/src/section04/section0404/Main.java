package section04.section0404;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private int solution(String s, String t) {
        // s 문자열과 t 문자열이 주어질 때 t 문자열과 아나그램이 되는 s 문자열의 갯수를 구하라. (대소문자 구분)
        int answer = 0;
        // map 의 모든 values 를 한번에 같은 값으로 설정하는 방법을 모르므로 map 2개를 사용한다.
        //     !  -> map.equals() 를 사용하면 해결할 수 있는 문제 (핵심)
        // ***** map 의 모든 values 를 한번에 비교하는 방법은 객체비교를 하면 됐었는데, map.equals() 메소드를 떠올리지 못했다. *****

        // map 세팅
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            bMap.put(t.charAt(i), bMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 출력
//        for (Character character : bMap.keySet()) {
//            System.out.println(character + " = " + bMap.get(character));
//        }

        // aMap 초기 세팅 (0부터 t-1개까지)
        for (int i = 0; i < t.length() - 1; i++) {
            aMap.put(s.charAt(i), aMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // aMap 과 bMap 을 two pointer 를 조절해 비교한다.
        int lt = 0;
        // aMap 에 rt 값을 담고 bMap 과 같은지 확인 -> 1.같으면 카운트++, 2.다르면? 패스.
        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            aMap.put(s.charAt(rt), aMap.getOrDefault(s.charAt(rt), 0) + 1);
            if (aMap.equals(bMap)) {
                answer++;
            }
            // 다음 루프가 돌기 전에 aMap 에서 lt 값을 제거한다. -> 이 때, lt 는 aMap 에 반드시 존재한다. lt 값이 1이면 제거, 1이상이면 -1 연산.
            if (aMap.get(s.charAt(lt)) > 1) {
                aMap.put(s.charAt(lt), aMap.get(s.charAt(lt)) - 1);
            } else {
                aMap.remove(s.charAt(lt));
            }
            // lt ++ 해준다. rt는 루프문에서 절로 ++ 된다.
            // 다음 루프가 돌았을 때, rt 값을 aMap 에 담고 bMap 과 같은지 확인 -> 위 절차를 반복한다.
            lt++;
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
