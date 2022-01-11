package section02.section0207;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> checkList = new ArrayList<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                checkList.add(scanner.nextInt());
            }
        }
        System.out.print(solution(n, checkList));

    }

    private static int solution(int n, List<Integer> checkList) {
        // n
        // checkList = [1, 0, 1, 1, 1, 0, 0, 1, 1, 0]
        // resultList =[1, 0, 1, 2, 3, 0, 0, 1, 2, 0]
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (checkList.get(i) == 0) {
                resultList.add(0);
            } else {    // checkList 1일 때
                if (i == 0) {   // 첫번째 인덱스 값은 바로 1점 주기.
                    resultList.add(checkList.get(i));
                } else {    // 나머지 인덱스 ( i = 2,
                    // 앞의 인덱스가 0이면 점수리스트에 체크리스트 인덱스를 더하고
                    // 앞의 인덱스가 1이면 점수리스트에 앞의 점수 + 1(지금 인덱스 값) 을 더한다.
                    if (resultList.get(i - 1) == 0) {
                        resultList.add(checkList.get(i));
                    } else {    // i = 3
                        resultList.add(resultList.get(i-1) + checkList.get(i));
                    }
                }
            }
        }
        System.out.println("resultList = " + resultList);
        int sum = 0;
        for (Integer score : resultList) {
            sum = sum + score;
        }
        System.out.println("sum = " + sum);
        return sum;
    }

}
