package com.github.kellyihyeon.section01_basic.timeandspacecomplexity;

/**
 * n이 제곱수이면 1을 반환하고 제곱수가 아니면 0을 반환하는 함수를 작성하라.
 * n 은 10억 이하의 자연수이다.
 */
public class PerfectSquare {

    public static void main(String[] args) {
        int n = 9;
        int n2 = 693953651;
        int n3 = 756580036;

        int answer = new PerfectSquare().solution2(n3);
        System.out.println("answer = " + answer);
    }

    public int solution2(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                return 1;
            }
        }
        return 0;
    }
}
