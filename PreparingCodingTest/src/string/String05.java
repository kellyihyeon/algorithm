package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 모르겠다. 내일 다시 풀자.
public class String05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // a # ! b G E * T @ S  >> a, b, g, e, t, s -> s, t, e, g, b, a
        // S # ! T E G * b @ a
        // 0 1 2 3 4 5 6 7 8 9
        // 6번 반복
            // 10번 반복
                // 인덱스 자리 == 1이면 영문자이므로

        // 1. 영문자 자리는 1로 표시한다.
        // 2. 인덱스가 1인 곳에 뒤집어 놓은 배열의 알파벳을 하나씩 넣는다.
        // * 대문자 A to Z = 65 ~ 90 / 소문자 a to z = 97 ~ 122
        char[] rawChars = br.readLine().toCharArray();
        int[] indexArray = new int[rawChars.length];

        List<Character> characterList = new ArrayList<>();
        List<Character> reverseLetterStore = new ArrayList<>();

        // 영문자만 추려내서 배열 만들기
        for (int i = 0; i < rawChars.length; i++) {
            if ((64 < rawChars[i] && rawChars[i] < 91) || (96 < rawChars[i] && rawChars[i] < 123)) {    // 소문자나 대문자
                indexArray[i] = 1;
                characterList.add(rawChars[i]);
            }
//            else {
//                characterList.add('0');
//            }
            System.out.print(indexArray[i] + " ");
        }
        System.out.println();
        System.out.print(characterList);

        // 추려낸 영문자열 뒤집기
        // d 0 r n 0 0 h j 0 0 0
        // 0 0 0 j h 0 0 n r 0 d (뒤집기 성공)
        System.out.println();
        for (int i = characterList.size() - 1; i > -1; i--) {
            reverseLetterStore.add(characterList.get(i));
        }
        System.out.println(reverseLetterStore);

        for (int i = 0; i < rawChars.length; i++) {
            if (indexArray[i] == 1) {
//                for (int j = 0; j < reverseLetterStore.size(); j++) {
//
//                }
                rawChars[i] = reverseLetterStore.get(i);
            }
        }
        System.out.println();
        System.out.println(rawChars);
    }
}
