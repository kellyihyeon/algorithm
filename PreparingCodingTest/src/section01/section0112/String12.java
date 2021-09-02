package section01.section0112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class String12 {
    public static List<Character> solution(int n, String str) {

        String binaryString = "";
        for (int i = 0; i < str.trim().length(); i++) {
            if (str.charAt(i) == '#') {
                binaryString += "1";
            } else {
                binaryString += "0";
            }
        }

        int len = binaryString.trim().length();  // 글자 수
        int countOfNum = len / n;   // 항상 7글자 | 자를 글자 수

        List<String> store = new ArrayList<>();

        for (int i = 0; i < len; i += 7) {   // 4번 돌면서 문자열을 7글자로 분리 해야 한다
            String secretCode = binaryString.substring(i, countOfNum + i);
            store.add(secretCode);
        }   // store = [1000011, 1001111, 1001111, 1001100]

        List<Character> letters = new ArrayList<>();
        for (String code : store) {
            int decimal = Integer.parseInt(code, 2);
            letters.add((char) decimal);
        }

        return letters;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for (Character character : solution(n, str)) {
            System.out.print(character);
        }
    }
}
