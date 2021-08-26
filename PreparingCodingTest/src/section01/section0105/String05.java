package section01.section0105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class String05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * input: a#b!GE*T@S
         * 1. 영문자 자리의 인덱스 번호를 알아낸다. [0, 2, 3, 6, 7]
         * 2. 영문자만 꺼낸다. -> 역으로 저장한다. [a, b, G, E, T, S] -> [S, T, E, G, b, a]
         * 3. 원본의 영문자 자리 인덱스 번호에 역으로 저장한 영문자를 넣는다.
         */
        char[] rawChars = br.readLine().toCharArray();

        List<Character> alphabetList = new ArrayList<>();
        List<Character> reverseLetterStore = new ArrayList<>();
        List<Integer> numberOfIndex = new ArrayList<>();

        for (int i = 0; i < rawChars.length; i++) {
            if ((64 < rawChars[i] && rawChars[i] < 91) || (96 < rawChars[i] && rawChars[i] < 123)) {    // 소문자나 대문자
                numberOfIndex.add(i);                       // 영문자 해당 인덱스 번호
                alphabetList.add(rawChars[i]);              // 영문자만 저장
            }
        }
        System.out.println("numberOfIndex = " + numberOfIndex);
        System.out.println("alphabetList = " + alphabetList);

        for (int i = alphabetList.size() - 1; i > -1; i--) {
            reverseLetterStore.add(alphabetList.get(i));
        }
        System.out.println("reverseLetterStore = " + reverseLetterStore);


        for (int i = 0; i < numberOfIndex.size(); i++) {
            rawChars[numberOfIndex.get(i)] = reverseLetterStore.get(i);

        }
        for (int i = 0; i < rawChars.length; i++) {
            System.out.print(rawChars[i]);
        }
    }
}
