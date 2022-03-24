package section07.section0704;

/**
 * 피보나치 수열
 * 1 1 2 3 5 ...
 */
public class Main {

    private int fibonacci(int n) {
        // 첫번째, 두번째 항이 각각 1이다.
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            // n=4 -> f(3)+f(2)
            // 수열을 출력... 1 1 2 3 5 계산 과정말고 결과만.
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


    public static void main(String[] args) {
        Main M = new Main();
        int n = 10;
        for (int i = 1; i < n + 1; i++) {
            System.out.print(M.fibonacci(i) + " ");
        }
    }
}
