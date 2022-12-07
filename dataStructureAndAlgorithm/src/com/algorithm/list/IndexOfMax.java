package com.algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexOfMax {

    public int[] solution2(int[] arr) {
        // arr 의 최대값 구하기
        int max = Arrays.stream(arr).max().getAsInt();
        // 최대값이 몇개나 존재할지 모르기 때문에 List 자료형을 사용하자
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                indexes.add(i);
            }
        }
        // 인덱스 값의 목록을 배열로 변환하기
        int[] answer = new int[indexes.size()];
        for (int i = 0; i < indexes.size(); i++) {
            answer[i] = indexes.get(i);
        }
        return answer;
    }

    // input = [1, 3, 5, 4, 5, 2, 1]
    public List<Integer> solution(int[] arr) {
        // 최대값이 배열 arr 안에 몇개가 있을지 모르니 list 사용
        List<Integer> indexes = new ArrayList<>();

        // 최대값 구하기 -> 최대값 지정 후 루프를 돌면서 arr 값과 max 를 비교하면서 max 설정
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // 인덱스 저장하기
        for (int i = 0; i < arr.length; i++) {
            // max 와 같은 값이 있다면 list 자료구조에 인덱스를 저장
            if (max == arr[i]) {
                indexes.add(i);
            }
        }
        // 리스트를 배열로 변환하기
        return indexes;
    }
    
}
