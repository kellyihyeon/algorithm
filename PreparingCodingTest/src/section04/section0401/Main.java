package section04.section0401;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    private Character solution(int n, String result) {
        // 해당 후보가 배열에 포함되어있다면 몇개인지 카운트 세서 비교하면 안되나? -> 학생 수가 50명이라면 일일이 하나씩 카운팅..
        // result = BACBACCACCBDEDE
        Character answer = '0';

        Map<Character, Integer> mapping = new HashMap<>();
        Integer count = 0;
        // String 을 char 로 인덱스로 접근해서 map 에 없으면 만들어서 put 하고 카운팅 세고, map 에 있으면 카운팅만 센다.
        for (int i = 0; i < result.length(); i++) {
            if (mapping.containsKey(result.charAt(i))) {
                count = mapping.get(result.charAt(i));
                mapping.put(result.charAt(i), count + 1);
            } else {
                mapping.put(result.charAt(i), 1);
            }
        }

        // 가장 많은 득표수 구하기
        int max = 0;
        for (Integer value : mapping.values()) {
            if (max < value) {
                max = value;
            }
        }
        // 가장 많은 득표수를 가지고 있는 key(해당 후보) 구하기
        for (Character character : mapping.keySet()) {
            if (max == mapping.get(character)) {
                answer = character;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // n명의 반 학생 수가 주어지고, 학급 회장을 뽑기 위해 반 학생들이 투표한 결과가 주어진다.
        // A ~ E 후보 중 학급 회장으로 뽑히는 사람은 누구인지 출력하라. (동점자는 없고 회장은 단 한명이다.)
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        // 배열로 주어지는 게 아니라 String 으로 한 줄 주어진다.
        String result = scanner.next();

        System.out.println(M.solution(n, result));
    }
}
