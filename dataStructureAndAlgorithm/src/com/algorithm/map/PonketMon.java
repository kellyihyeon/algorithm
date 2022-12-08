package com.algorithm.map;

import java.util.Hashtable;
import java.util.Map;

public class PonketMon {

    // 최대한 많은 종류의 폰켓몬을 가져가야할 때, 최대 몇종류를 가져갈 수 있는지 리턴
    // 3마리 가져오기 -> (3:3, 2:2, 4:1) -> 3종류
    // 3마리 가져오기 -> (1:1, 3:2, 2:2, 4:1) -> 3종류
    // 3마리 가져오기 -> (3:4, 2:2) -> 2종류

    public int solution(int[] nums) {
        // 박사님의 폰켓몬 카테고리와 마리 수 정리하기
        // 폰켓몬 "카테고리 번호:갯수"가 한쌍이 되어야 하므로 Map 자료구조를 사용하자.
        // 루프를 돌면서 input을 map 에 저장한다. (input, count) -> (3:2, 1:1, 2:1)
        Map<Integer, Integer> map = new Hashtable<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, (map.get(num) + 1));
            }
            map.put(num, map.getOrDefault(num, 1));
        }

        // 폰켓몬 가져오기
        // 가져올 수 있는 마리 수 <= 존재하는 종류 수 -> 가져올 수 있는 마리 수
        // 가져올 수 있는 마리 수 > 존재하는 종류 수 -> 존재하는 종류 수
        int capacity = nums.length / 2;
        if (capacity <= map.keySet().size()) {
            return capacity;
        }

        return map.keySet().size();
    }

}
