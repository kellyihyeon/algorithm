package com.algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationCheck {

    // input = [4, 1, 3, 2] -> output = true
    // 길이가 n인 배열에 1부터 n까지 중복된 수 없이 들어있는지
    // 길이가 4인 배열 -> [1,2,3,4], 길이가 3인 배열 -> [1,2,3]
    // 길이가 n 이다 -> 길이가 정해져있지 않아서 알 수 없다 -> List 자료형을 사용하자
    // 효율성 테스트 -> 통과
    public boolean solution(int[] arr) {
        boolean answer = true;

        // arr 의 길이를 구하고 길이에 맞는 정답 만들기
        List<Integer> checker = new ArrayList<>();
        for (int i = 1; i < arr.length + 1; i++) {
            checker.add(i);
        }
        // arr 을 오름차순으로 정렬하고 정답과 일치하는지 비교하기
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != checker.get(i)) {
                return false;
            }
        }

        return answer;
    }

    // input = [4, 1, 3, 2] -> output = true
    // input = [4, 1, 3] -> output = false
    public static void main(String[] args) {
        PermutationCheck permutationCheck = new PermutationCheck();
        int[] arr = {4, 1, 3, 2};
        System.out.println(permutationCheck.solution(arr));;
    }
}
