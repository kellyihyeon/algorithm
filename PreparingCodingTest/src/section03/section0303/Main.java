package section03.section0303;

import java.util.Scanner;

public class Main {

    // Time Limit Exceeded -> 줄일 방법이 없을까?
    private int solution(int n, int k, int[] arr) {
        // k를 알고 있다면 pointer 를 k 개 만들고, 각 pointer 를 +1씩 증감 시키다가 마지막 pointer 가 n 일때 스탑 하는 조건으로
        // pointer 를 k개 만들어야 하므로 포인터를 배열로 만든다. k가 3이라고 가정하자. int[] pointers = new int[k]; -> [0,0,0]
        // pointers 에 pointer 값을 넣어야겠지? for 문을 k 만큼 돌면서 포인터배열에 i번째 = i 값을 대입.
        int[] pointers = new int[k];
        for (int i = 0; i < k; i++) {
            pointers[i] = i;    // pointers = [0,1,2]
        }

        int max = 0;
        int calc = 0;

        while (pointers[k - 1] != n) {
            // 포인터의 갯수를 알 수 없으니, 포인터는 0번째부터 마지막번째까지 인덱스를 이용한다.
            // 조건은 포인터의 마지막 인덱스 값 + 1로 설정해야 k 번 돌 수 있다.
            for (int i = pointers[0]; i < pointers[k-1]+1; i++) { // pointers[k-1]+1
                // 연속된 k 매출액 다 더하고
                calc += arr[i];
            }
            // 포인터들도 +1씩 증가시킨다.
            for (int i = 0; i < k; i++) {
                pointers[i] = pointers[i] + 1;
            }

            // max 값을 만들어서 더 큰 매출액을 더해나간다. 언제까지? 포인터의 마지막 값이 n 과 같아지면 while 문을 종료한다.
            if (max < calc) {
                max = calc;
            }
            calc = 0;

        }

        return max;
    }

    public static void main(String[] args) {
        // n일 동안의 매출 기록 데이터가 주어지고 연속된 k일이 주어졌을 때 k일 동안 합한 매출 기록 중 최대 매출액을 출력하라.
        // n과 k가 주어지고 매출데이터 배열이 주어진다.
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n,k,arr));

    }

}
