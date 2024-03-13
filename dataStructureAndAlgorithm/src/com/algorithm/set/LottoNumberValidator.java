package com.algorithm.set;

import java.util.HashSet;
import java.util.Set;

public class LottoNumberValidator {

    public static void main(String[] args) {
        int[] lotto = {3, 19, 34, 39, 39, 20};
        int[] lotto2 = {4, 7, 32, 43, 22, 19};

        boolean answer = new LottoNumberValidator().solution(lotto2);
        System.out.println("answer = " + answer);
    }

    public boolean solution(int[] lotto) {
        boolean answer = true;
        Set<Integer> numbers = new HashSet<>();

        final int MIN = 1;
        final int MAX = 45;

        for (int lottoNumber : lotto) {
            if (MIN > lottoNumber || lottoNumber > MAX) {
                answer = false;
                break;
            }

            if (numbers.contains(lottoNumber)) {
                answer = false;
                break;
            }

            numbers.add(lottoNumber);

        }

        return answer;
    }
}
