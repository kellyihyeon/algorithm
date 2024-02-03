package com.algorithm.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * SEE: 문제를 안읽어서 '중복 없이' 키워드를 못봄
 */
public class PermutationCheck {

    // 시간 복잡도: O(nlogn)
    public boolean answer(int[] arr) {
        Arrays.sort(arr);

        int[] answers = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answers[i] = i + 1;
        }

        return Arrays.equals(arr, answers);
    }

    // 효율성 테스트에서 시간 초과 나옴
    public boolean lecture(int[] arr) {
        for (int i = 1; i < arr.length + 1; i++) {
            int found = 0;

            for (int a : arr) {
                if (a == i) {
                    found++;
                }
            }

            if (found != 1) {
                return false;
            }
        }
        return true;
    }

    // arr 배열을 오름차순으로 정렬한 후 배열의 마지막 숫자가 배열의 길이와 동일한지 비교
    // => 프로그래머스 툴에서는 정답 으로 체킹 되지만 중복되는 경우는 찾아낼 수 없음
    public boolean solution3(int[] arr) {
        Arrays.sort(arr);
        int lastNumber = arr[arr.length - 1];
        return arr.length == lastNumber;
    }

    // arr 의 길이를 이용해서 배열의 원소와 arr 의 길이를 비교 ==> 오답 (숫자가 중복으로 들어있는 경우!)
    public boolean solution2(int[] arr) {
        for (int number : arr) {
            if (number > arr.length) {
                return false;
            }
        }

        return true;
    }

    // 제일 처음 생각한 문제 해결 방법 => 오답 (숫자가 중복으로 들어있는 경우는 체크 못함)
    public boolean solution1(int[] arr) {
        boolean answer = true;
        List<Integer> checkList = new LinkedList<>();
        for (int i = 1; i < arr.length + 1; i++) {
            checkList.add(i);

        }
        for (int number : arr) {
            if (!checkList.contains(number)) {
                answer = false;
            }
        }

        return answer;
    }

}
