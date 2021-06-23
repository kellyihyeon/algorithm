package basic.recursion;

public class Code04 {

    public static void main(String[] args) {

    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }

    public int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    //Euclid Method
    public static double gcd(int m, int n) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;    //swap m and n
        }

        // 12, 8
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m%n);   //8, 4
        }
    }

    //Euclid Method: 좀 더 단순한 버전
    public static int gcdSimple(int p, int q) {
        // 12, 8
        if (q == 0) {
            return p;
        } else {
            return gcdSimple(q, p%q);   //8, 4
        }
    }
}
