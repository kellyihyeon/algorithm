package section06.section0603;

import java.util.Scanner;

// n 개의 배열을 삽입 정렬하여 출력하라.
public class Main {

    private int[] solution(int n, int[] arr) {
        // arr[1] ~ arr[n] 까지 순환한다.
        // 첫 번째 루프:arr[1]과 앞 원소를 비교해 작은 원소를 0번째로 보낸다.
        //두 번째 루프:arr[2]와 앞 원소들을 비교해 작은 원소를 앞으로 보낸다.
        //마지막 루프:arr[5]와 앞 원소들을 비교해 작은 원소를 앞으로 보낸다. 앞으로 보내면서 자기보다 더 작은 원소를 만나면 스탑.
        // 규칙:
        // 앞의 수가 하나밖에 없을 때 만약 key element 가 더 작은 수면? 앞과 key 를 스와프
        // 앞의 수가 여러개라서 비교해가면서 앞으로 갈지 스탑할지 결정해야 한다면?
        for (int i = 1; i < n; i++) {
            // 크게 도는 건 i로 돌고, 작게 도는 건 j로 돌아서 j는 i부터 시작해 -- 시킨다.
            for (int j = i; j > 0; j--) {
                // arr[j] 와 arr[j-1] 비교
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
                // j가 2일 때, 2인덱스, 1인덱스 비교해서 스와프 -> j가 1일 때, 1인덱스 0인덱스 비교해서 스와프
                // 만약 앞 숫자와 비교를 했는데 key element 가 더 크면 더 앞의 숫자와는 비교하지 않아도 된다.
            }


        }

        return arr;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : M.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
