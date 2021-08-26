package section01.section0104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input
        int n = Integer.parseInt(br.readLine());

        String[] wordArray = new String[n];
        for (int i = 0; i < n; i++) {
            String inputWord = br.readLine();
            wordArray[i] = inputWord;
        }

        // output
        for (int i = 0; i < wordArray.length; i++) {
            int stringLength = wordArray[i].length();   // 4글자
            String word = wordArray[i];   // good
            for (int j = stringLength - 1; j > -1; j--) {   // 3, 2, 1, 0
                final char[] chars = word.toCharArray();
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}
