package section01.section0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String07 {

    private static String solution(String str) {
        String tmp = "";
        final String word = str.toLowerCase();

        for (int i = word.length() - 1; i > -1; i--) {
            tmp += word.toCharArray()[i];
        }

        if (word.equals(tmp)) {
            return "YES";
        } else {
            return "NO";
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();

        System.out.println(solution(str));
    }
}
