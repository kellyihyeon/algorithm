package section03.section0306;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // 길이가 n인 0과 1로 구성된 수열이 주어지고, 0을 1로 바꿀 수 있는 기회가 k번 주어진다.
    // 0 -> 1로 바꿨을 때 1로만 이루어진 수열의 길이가 가장 긴 경우를 찾아서 최대길이가 얼마인지 출력하라.

    private int solution(int n, int k, int[] arr) {
        // 0이 있는 인덱스 값을 배열에 저장해보자. 0인덱스 값 = [2,3,6,9,12]
        List<Integer> store = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                store.add(i);
            }
        }
        int leftPointer = 0;
        int rightPointer = 0;
        // 0의 인덱스 값을 가지고서 최대 길이를 구한다.
        // 제일 처음 초기값을 세팅해준다. store = [2,3,6,9,12] / 초기 세팅은 k번째(2) 인덱스 값까지 1로 구성되어 있으니 최대길이 설정.
        int max = store.get(k);
        int length = 0;
        // 이제 일반적인 세팅을 시작한다. 시작은 k(2)부터 ++해서 올린다.
        for (int i = k; i < store.size(); i++) {    //store.size = 5; k=2,3,4
            // rt 값을 k+1로 잡는다. rt=3; lt=0(초기세팅); rt 값에서 lt 값을 빼는 게 1로 구성된 수열의 길이이다.
            // k번 만큼 0을 1로 바꾼다고 가정하면, 'lt+1번째 ~ rt 번째' 는 연속된 1로만 되어있는 수열이다.
            // *** i 가 4 일때 (마지막 일때) = rt는 arr 의 마지막 값 ***
            if (i < (store.size() - 1)) {
                rightPointer = store.get(i + 1);
            } else {
                rightPointer = arr[arr.length-1];
            }

            length = rightPointer - (store.get(leftPointer) + 1);
            if (max < length) {
                max = length;
            }
            leftPointer++;

        }

        return max;
    }

    public static void main(String[] args) {
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
