package section07.section0703;

/**
 * 팩토리얼
 */
public class Main {

    // n = 5 -> 5!
    private int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Main M = new Main();
        System.out.println(M.factorial(5));
    }
}
