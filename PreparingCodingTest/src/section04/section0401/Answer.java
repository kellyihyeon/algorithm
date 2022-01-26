package section04.section0401;

import java.util.HashMap;
import java.util.Scanner;

public class Answer {

    /**
     * map.getOrDefault(Object key, V defaultValue) 메소드가 핵심 !!
     */
    private char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            //System.out.println(key + " " + map.get(key));
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Answer M = new Answer();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(M.solution(n, str));
    }
}
