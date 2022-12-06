package com.algorithm.list;

public class NumberToArray {

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
