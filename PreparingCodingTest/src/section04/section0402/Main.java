package section04.section0402;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private String solution(String a, String b) {
        String answer = " ";
        // 우선 a의 단어가 각 알파벳이 몇개 인지 Map 에 담는다.
        Map<Character, Integer> mapForA = new HashMap<>();
        Map<Character, Integer> mapForB = new HashMap<>();
        int count = 0;
        // b 단어도 map 에 담을 필요가 있는지 생각 -> 담아야 한다. value 의 갯수가 맞는지까지 비교해보려면 b 도 map 구조가 필요하기 때문이다. map 을 안쓰면 이중 for 문을 사용해야 한다. 시간 복잡도가 n2이 된다.
        for (int i = 0; i < a.length(); i++) {
            mapForA.put(a.charAt(i), mapForA.getOrDefault(a.charAt(i), count) + 1);
            mapForB.put(b.charAt(i), mapForB.getOrDefault(b.charAt(i), count) + 1);
        }
        // 아나그램인지 여부를 판단해야 하기 때문에 a의 map 에서 첫번째 키를 꺼내서 b 단어와 비교해보고 value 까지 일치하는지 확인해본다.
        // key 를 순서대로 비교해볼 때 key 가 다르거나 key 는 같지만 key 에 맞는 value 가 다르면 뒤는 비교해볼 필요도 없이 NO 이기 때문이다.
        for (int i = 0; i < b.length(); i++) {
            if (mapForA.containsKey(b.charAt(i)) && mapForA.get(b.charAt(i)).equals(mapForB.get(b.charAt(i)))) {
                answer = "YES";
            } else {
                answer = "NO";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 알파벳의 나열 순서는 다르지만 그 구성이 같은 경우. 두 단어를 재배열하면 상대편 단어가 될 수 있다. 이를 아나그램이라 한다.
        // 길이가 같은 두 개의 단어가 주어지는데, 두 단어가 아나그램이면 YES, 아니면 NO를 출력하라. (*아나그램 판별 시 대소문자 구분)
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(M.solution(a, b));
    }
}
