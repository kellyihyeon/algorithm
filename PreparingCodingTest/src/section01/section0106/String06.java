package section01.section0106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class String06 {

    public static StringBuilder solution(String str) {
        StringBuilder answer = new StringBuilder();
        final char[] toCharArray = str.toCharArray();   // k s e k k s e t

        // str의 길이만큼 돌면서 검사를 한다.
        List<Character> store = new ArrayList<>();

        for (int i = 0; i < toCharArray.length; i++) {
            for (int j = 0; j < str.length(); j++) {    // ksekkset
                if (toCharArray[i] == str.charAt(j)) {
                    if (!store.contains(toCharArray[i])) {
                        store.add(str.charAt(j));
                    }
                }
            }
        }
        for (Character character : store) {
            answer.append(character);
        }


        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String str = br.readLine();

        System.out.println(solution(str));
    }
}
