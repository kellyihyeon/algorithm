package section07.section0704;

/**
 * 피보나치 수열
 * 1. 재귀로 작성 -> 함수가 호출 될 때마다 스택에 프레임이 생긴다. 메모리에 프레임이 엄청 생긴다. (성능 저하)
 * 2. for 문으로 작성 -> 함수에 프레임 하나만 가지고 for 문이 도는 것 (메인 메서드 스택)
 *
 * 배운 점: 메모이제이션
 */
public class Answer {

    static int[] fibo;

    private int DFS(int n) {
        // 메모이제이션 활용해서 시간복잡도 확 줄이기 !
        if (fibo[n] > 0) {
            return fibo[n];
        }

        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = DFS(n - 2) + DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Answer A = new Answer();
        int n = 45;
        fibo = new int[n + 1];
        A.DFS(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

}
