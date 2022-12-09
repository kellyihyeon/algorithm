package com.algorithm.map;

import java.util.Hashtable;
import java.util.Map;

public class Camouflage {

    // 스파이의 의상은 날마다 겹치면 안된다. 서로 다른 옷 조합의 수를 리턴하라.
    // "의상 종류:의상 갯수" 형태로 저장할 수 있는 Map 자료형을 사용하자. -> (모자: 노란모자, 초록터번), (안경: 파란 선글라스)
    // 경우의 수: 의상 종류의 각 의상 갯수를 곱한 것 - 1(전부 안입는 경우)
    public int solution(String[][] clothes) {
        // 의상 종류와 의상 갯수 담기
        Map<String, Integer> map = new Hashtable<>();
        for (int i = 0; i < clothes.length; i++) {  // 0,1,2
            String key = clothes[i][1];
            if (map.containsKey(key)) {
                map.put(key, (map.get(key) + 1));
            } else {
                map.put(key, map.getOrDefault(key, 1));
            }
        }

        // 경우의 수 구하기
        int answer = 1;
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }
}
