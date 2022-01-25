package section03.section0305;

import java.util.Scanner;

public class Answer2 {

    private int solution(int n) {
        int answer = 0;
        // cnt = 연속된 자연수의 갯수
        // n = 15
        // cnt = 1과 2 (처음 세팅: 2개) / n = 15 - 1 - 2 -> 12
        // 12는 2로 나눴을 때 0으로 나눠 떨어지므로 (몫:6) 분배해준다.
        // 1 2  <- cnt가 2인 경우
        // 6 6   -> 7,8 연속된 자연수이므로 answer++
        // 1 2 3  <- cnt가 3인 경우
        // 3 3 3

        int cnt = 1;
        n--;
        while (n > 0) {
            cnt++;  // 15에서 1과 2를 빼놓은 상태에서 3을 빼는 것이니 연결 되는 것
            n = n - cnt;
            if (n % cnt == 0) {     // cnt로 나눴을 때 0으로 나눠떨어지면 cnt를 각각 분배해 줄 수 있다.
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Answer2 M = new Answer2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(M.solution(n));
    }
}
