package section02.section0206;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        List<String> stringList = new ArrayList<>();

        if (sc.hasNextLine()) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                stringList.add(sc.next());
            }
        }

        final List<Integer> answerList = solution(n, stringList);
        for (Integer answer : answerList) {
            System.out.print(answer + " ");
        }
    }

    private static List<Integer> solution(int n, List<String> stringList) {
        // 숫자 뒤집기
        List<String> reverseStringList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<Integer> finalReverseNumber = new ArrayList<>();

        for (String num : stringList) {  // [32, 55, 62, 20, 250, 370, 200, 30, 100]
            reverseStringList.clear();

            for (int i = num.length() - 1; i > -1; i--) {   // i = 1, 0
                reverseStringList.add(String.valueOf(num.charAt(i)));
            }
//            System.out.println("reverseStringList = " + reverseStringList); // reverseStringList = [2, 3]

            sb.setLength(0);
            for (String reverseString : reverseStringList) {
                if (reverseString.equals("0")) {
                    if (sb.length() > 0) {
                        sb.append(reverseString);
                    }
                }
                else {   // mistake !
                    sb.append(reverseString);   // 902, 002
                }
            }
//            System.out.println("sb = " + sb);   // sb = 23,

            final int parseNum = Integer.parseInt(sb.toString());
//            System.out.println("parseNum = " + parseNum);  // parseNum = 23
            finalReverseNumber.add(parseNum);
        }   // for

//        System.out.println("finalReverseNumber = " + finalReverseNumber);
        // finalReverseNumber 숫자 리스트에 있는 숫자가 소수인지 판단하기
        boolean check = true;
        List<Integer> answerList = new ArrayList<>();

        for (Integer number : finalReverseNumber) { // number = [23, 55, 26, 2, 52, 73, 2, 3, 1]
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }

            if (check && number > 1) {
                answerList.add(number); // 23, 55
            }
            check = true;
        }// for

        return answerList;
    }
}
