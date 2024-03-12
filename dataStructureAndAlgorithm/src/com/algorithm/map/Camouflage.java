package com.algorithm.map;

import java.util.*;

public class Camouflage {

    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}; //5
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}; //3

        System.out.println(new Camouflage().solution(clothes1));
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        for (Integer count : map.values()) {
            answer *= count + 1;
        }
        return answer - 1;
    }
}
