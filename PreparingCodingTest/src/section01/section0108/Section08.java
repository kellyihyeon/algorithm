package section01.section0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section08 {
    public static String solution(String str) {     // found7, time: study; Yduts; emit, 7Dnuof
        String answer = "YES";
        final char[] toCharArray = str.toUpperCase().toCharArray();
        StringBuilder resultString = new StringBuilder();

        for (char c : toCharArray) {
            if (Character.isAlphabetic(c)) {
                resultString.append(c);
            }
        }
//        System.out.println("resultString = " + resultString);

        final int resultStringLength = resultString.length();
        for (int i = 0; i < resultStringLength / 2; i++) {
            if (resultString.charAt(i) != resultString.charAt((resultStringLength - 1) - i)) {
                answer = "NO";
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();

        System.out.println(solution(str));
    }
}
