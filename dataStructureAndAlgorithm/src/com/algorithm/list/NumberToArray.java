package com.algorithm.list;

import java.util.ArrayList;
import java.util.List;

public class NumberToArray {

    // 자연수 n의 자리수는 고정이 아니다. -> 자리수로 뜯을 수는 없다.
    // 몇개의 원소가 나오는지 알 수가 없으니 List 자료형을 사용하자.
    // 자연수를 10으로 나눠서 나머지 만들기 -> 1234.5
    // 나머지를 List 자료형에 담기
    // 자연수를 0이 될때까지 반복해서 10으로 나눈 상태를 저장하기 -> 1234 -> 123 -> 12 -> 1 -> 0
    // List 자료형을 배열로 변환하기
    public int[] solution2(long n) {
        List<Integer> components = new ArrayList<>();

        while (n > 0) {
            components.add( (int)(n % 10) );    // 형변환 할 때 괄호 잘 묶기 !!!
            n /=  10;
        }
        return components.stream().mapToInt(component -> component).toArray();
    }

    // 자연수 n = 12345
    // n의 자리수가 고정이 아니다. -> n 을 숫자로써 하나씩 뜯을 방법은 없다.
    // 자연수 n을 문자열로 바꾼다. -> "12345"
    // 문자열을 char 배열로 바꾼다. -> {1, 2, 3, 4, 5}
    // char[]를 루프 돌면서 문자를 정수로 바꾼다.
    // 정수가 담긴 배열을 reverse 한다. -> 인덱스 마지막부터 추출
    public int[] solution(long n) {
        // 자연수 n -> 문자열로 변환
        String strNum = String.valueOf(n);
        // 문자열 -> char 배열로 변환
        char[] charsNum = strNum.toCharArray();

        int[] answer = new int[charsNum.length];
        // 루프 돌면서 char 배열 -> 정수로 변환하여 list 타입에 저장
        int length = charsNum.length - 1;
        for (int i =  length; i > -1; i--) {
            int num = Integer.parseInt(String.valueOf(charsNum[i]));
            answer[length - i] = num;
        }

        return answer;
    }
}
