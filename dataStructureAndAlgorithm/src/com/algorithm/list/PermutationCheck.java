package com.algorithm.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationCheck {

    // 배열의 길이는 10만이라고 가정. -> 효율성 테스트 실패

    public boolean solution(int[] arr) {
        boolean answer = true;
        int[] checkers = new int[arr.length + 1];
        // 0번째에 1 체크
        checkers[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            // 두번째 테스트케이스의 경우에는 input 길이가 3이지만, 4값이 존재하므로 순열의 범위를 넘어섰으니 false 를 반환하게 한다.
            if (arr[i] > arr.length) {
                return false;
            }
            // 루프를 돌면서 checker[input+1]에 1로 체크한다. 인덱스를 맞춰놓고 숫자가 존재하면 1로 체크하는 방법
            checkers[arr[i]] = 1;
        }
        List<Integer> results = Arrays.stream(checkers).boxed().collect(Collectors.toList());

        // checker 가 전부 1로 차있으면 true, 그렇지 않으면 false 를 반환한다.
        if (results.contains(0)) {
            answer = false;
        }
        return answer;
    }

    // input = [4, 1, 3, 2] -> output = true
    // input = [4, 1, 3] -> output = false
    public static void main(String[] args) {
        PermutationCheck permutationCheck = new PermutationCheck();
        int[] arr = {4, 1, 3};
        System.out.println(permutationCheck.solution(arr));;
    }
}
