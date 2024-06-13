package com.github.kellyihyeon.section01_basic.timeandspacecomplexity;

/**
 * n 이하의 자연수 중에서 3의 배수이거나 5의 배수인 수를 모두 합한 값을 반환하는 함수를 작성하라.
 * n은 10만 이하의 자연수이다.
 */
public class MultipleFinder {

    public static void main(String[] args) {
        int n = 16;
        int n2 = 34567;
        int n3 = 27639;

        int answer = new MultipleFinder().solution(n);
        System.out.println("answer = " + answer);
    }

    // 시간복잡도: O(N)
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
