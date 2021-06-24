package basic.recursion;

import java.util.Scanner;

public class Code05 {

    // 문자열의 길이
    public static int length(String str) {
        if (str.equals("")) {
            return 0;
        } else {
            return 1 + length(str.substring(1));
        }
    }

    // 문자열 프린트
    public static void printChars(String str) {
        if (str.length() == 0) {
            return;
        } else {
            System.out.println("str.charAt(0)" + str.charAt(0));
            printChars(str.substring(1));
        }
    }

    // 문자열을 뒤집어 프린트
    public static void printCharsReverse(String str) {
        if (str.length() == 0) {
            return;
        } else {
            printCharsReverse(str.substring(1));
            System.out.println("str.charAt(0) = " + str.charAt(0));
        }
    }

    // 2진수로 변환하여 출력
    public void printInBinary(int n) {
        if (n < 2) {
            System.out.print(n);
        } else {
            printInBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    // 배열의 합 구하기
    public static int sum(int n, int[] data) {
        if (n <= 0) {
            return 0;
        } else {
            return sum(n - 1, data) + data[n - 1];
        }
    }

    // 데이터파일로부터 n개의 정수 읽어오기
    public void readFrom(int n, int[] data, Scanner in) {
        if (n == 0) {
            return;
        } else {
            readFrom(n-1, data, in);
            data[n - 1] = in.nextInt();
        }
    }


    public static void main(String[] args) {
//        String str = "dev";
//        printCharsReverse(str);

        int n = 4;
        int[] data = {5, 3, 7, 6, 2, 8};
        System.out.println(sum(n, data));
    }
}
