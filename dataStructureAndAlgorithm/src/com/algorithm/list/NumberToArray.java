package com.algorithm.list;

import java.util.LinkedList;
import java.util.List;

public class NumberToArray {

    // 수학적 사고방식으로 접근하는 방법
    public int[] answer(long n) {
        List<Integer> answer = new LinkedList<>();

        while (n != 0) {
            int rest = (int) (n % 10);
            answer.add(rest);
            n  = n / 10;
        }

        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    // 마지막 인덱스를 구해서 for 문으로 lastIndex 부터 거꾸로 넣는 방법
    public int[] solution(long n) {
        String characterNumber = String.valueOf(n);
        int length = characterNumber.length();

        int[] answer = new int[length];
        int lastIndex = length - 1;
        for (int i = lastIndex; i > -1; i--) {
            int correctIndex = lastIndex - i;
            answer[correctIndex] = Character.getNumericValue(characterNumber.charAt(i));
        }

        return answer;
    }
}
