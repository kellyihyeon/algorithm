package com.github.kellyihyeon.section01_timecomplexity;

/**
 * n 이하의 수 중에서 가장 큰 2의 거듭제곱수를 반환하는 함수를 작성하라.
 * n은 10억 이하의 자연수이다.
 */
public class MaxPowerFinder {

    public static void main(String[] args) {
        int n = 5;  // 4
        int n2 = 97615282;  // 67108864
        int n3 = 1024;  // 1024

        int answer = new MaxPowerFinder().solution(n3);
        System.out.println("answer = " + answer);
    }

    public int solution(int n) {
        int answer = 1;
        while (n != 1) {
            answer *= 2;
            n /= 2;
        }

        return answer;
    }
}
