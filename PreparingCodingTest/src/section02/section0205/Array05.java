package section02.section0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Array05 {

    // Time Limit Exceeded 나왔지만 최선을 다해서 풀었다.
    public static int solution(int n) { // n = 20
        // 1부터 n까지 소수 개수 출력 프로그램
        // n=20? {2,3,5,7,11,13,17,19} output = {8}
        // 첫 줄에 자연수의 개수 N(2<=N<=200,000)
        Set<Integer> tmpList = new HashSet<>();
        for (int i = 3; i < n+1; i++) { // 3부터 20까지
            for (int j = 2; j < i; j++) { // i가 6 일때 j는 2,3,4,5
                int remainder = i % j;  // 6%2, 6%3, 6%4, 6%5
                System.out.println("remainder = " + i + "%" + j);
                if (remainder == 0) {   // 나머지가 0인 경우
                    tmpList.add(i);
                }
            }
        }
        System.out.println("tmpList = " + tmpList);   // tmpList = [16, 18, 4, 20, 6, 8, 9, 10, 12, 14, 15]
        List<Integer> list = new ArrayList<>(tmpList);
        List<Integer> answer = new ArrayList<>();       // answer = [2 ~ 20]
        for (int i = 2; i < n + 1; i++) {
            answer.add(i);
        }
        for (int i = 0; i < tmpList.size(); i++) {
            if (answer.contains(list.get(i))) {
                answer.remove(list.get(i));
            }
        }
        System.out.println("answer = " + answer);
        return answer.size();
    }

    // 에라토스테네스 체로 풀기
    private static int solution2(int n) {
        // n = 6
        //   1|2|3|4|5|6
        // 0|1|2|3|4|5|6  -> 인덱스는 7개
        int[] index = new int[n + 1];
        int count = 0;

        for (int i = 2; i < n+1; i++) {   // i = [2, 3, 4, 5, 6]
            if (index[i] == 0) {    // index[2][3][4][5] 가 0이라면 // index[6]은? -> 얘도 체크
                count++;
                for (int j = i; j < n+1; j = j + i) { // j = [2, 4, 6]
                    index[j] = 1;
                }

            }

        } // for
        System.out.println("count = " + count);
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // n = 20

        System.out.println(solution2(n));
    }
}
