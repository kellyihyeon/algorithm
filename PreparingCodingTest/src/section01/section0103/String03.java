package section01.section0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] rawString = br.readLine().split(" ");
        int max = rawString[0].length();
        int index = 0;

        // 1) 14 / 14 / 14 / 14 / 14
        // 1-1) 5 / 14 / 2 / 4 / 5
        // 2) 5 / 6 / 18 / 5 / 1 / 18
        for (int i = 1; i < rawString.length; i++) {
            if (max < rawString[i].length()) {  // 다른 max 가 나온 경우
                max = rawString[i].length();
                index = i;  // index = 2;
            } else if (max == rawString[i].length()){   // 같을 경우
                if (index > i) {
                    index = i;
                }
            }

        }
        System.out.println(rawString[index]);
    }
}
