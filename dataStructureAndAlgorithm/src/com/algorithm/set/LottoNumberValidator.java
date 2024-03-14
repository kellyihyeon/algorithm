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

    public boolean useSet(int[] lotto) {
        Set<Integer> set = new HashSet<>();

        for (int num : lotto) {
            if (num < 0 || num > 45) {
                return false;
            }

            set.add(num);
        }

        return set.size() == lotto.length;
    }


    public boolean useArray(int[] lotto) {
        boolean[] checker = new boolean[45 + 1];

        for (int num : lotto) {
            if (num < 0 || num > 45) {
                return false;
            }

            if (checker[num]) {
                return false;
            }

            checker[num] = true;
        }

        return true;
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
