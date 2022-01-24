package section03.section0305;

import java.util.Scanner;

public class Main {
    private int solution(int n, int[] arr) {
        // pointer 2개를 이용한다. pointer1= 첫 인덱스,  pointer2= 마지막 인덱스
        // sum 이 n과 같아졌으면 counter++, 2번 포인터를 먼저++ -> sum = sum - arr[1번포인터] + arr[2번포인터] -> 1번 포인터 마저 ++ 하면서 포인터를 한칸씩 오른쪽으로 옮긴다.
        // 포인터를 오른쪽으로 이동시켜 나가면서 포인터의 위치가 겹쳐지면(같아지면) 종료한다.
        int answer = 0;
        int sum = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        // 처음에는 n과 같거나 n을 초과하는 지점까지 전부 합한다. 그리고 pointer2 의 처음 위치를 세팅한다.
        for (int i = 0; i < n; i++) {
            if (sum < n) {
                sum = sum + arr[i];
                pointer2 = i;
            } else {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (pointer1 == pointer2) {
                break;
            }
            // 만약 n보다 작아지면 position2를 ++하고 sum 이랑 비교한다.
            if (sum < n) {
                pointer2++;
                sum = sum + arr[pointer2];
                // 같아졌으면 counter++, 다음 인덱스 저장하고 position1, position2 둘다 ++ 해서 오른쪽으로 옮긴다. sum = sum - arr[1번포지션] + arr[2번포지션]
            } else if (sum == n) {
                answer++;
                pointer2++;
                sum = sum - arr[pointer1] + arr[pointer2];
                pointer1++;
            } else {
                // sum 이 n과 같거나 작아졌는지 비교하고 그럴 때까지 sum 에서 1번포지션값 빼고 position1 만 ++해서 오른쪽으로 옮긴다.
                while (sum > n) {
                    sum = sum - arr[pointer1];
                    pointer1++;
                }
            }

        }

        return answer;
    }


    public static void main(String[] args) {
        // 양의 정수 n이 입력된다. 2개 이상의 연속된 수의 합이 n이 되는 경우의 수를 출력하라.
        Main M= new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // for 문으로 1부터 n 까지로 된 배열을 만든다.
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        System.out.println(M.solution(n, arr));

    }
}
