package section06.section0610;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 결정 알고리즘
 */
public class Main {

    // n 개의 마구간이 수직선상에 있고 각 마구간은 좌표를 가진다. (좌표가 중복되는 일은 없다.)
    // c 마리의 말들이 있는데, 말들은 서로 가까이 있지 않는다.
    // 각 마구간에 한 마리의 말만 넣을 수 있다.
    // 가장 가까운 두 말의 거리가 최대가 되게 말을 배치하고 싶다. (최대한 말들을 멀리 떨어뜨려 놓고 싶다는 얘기군 -> 어느정도까지 떨어뜨려 놓을 수 있는가?)
    // c 마리의 말을 n 개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 값을 출력하라.

    // - -   -       - -
    // 1 2 3 4 5 6 7 8 9
    private int solution(int n, int c, int[] arr) {
        int answer = 1;
        // 마구간 좌표 1 2 4 8 9  -> 좌표를 오름차순으로 정렬하자.
        Arrays.sort(arr);
        // 말 3마리를 최대한 각각 떨어뜨려 놓고 싶다. 마구간의 좌표는 1씩 늘어나고 현재 1 ~ 9 마구간 자리를 가지고 있다.
        // 말을 최대한 멀리 떨어뜨려 놓을 수 있는 방법은 가지고 있는 마구간 좌표 중 최소값, 최대값을 찾는다.
        // 1 ~~~ 9 에 말 각각 넣어놓으면 최대한 멀찍이 떨어뜨려 놓을 수 있다. lt, rt.
        int lt = Integer.MAX_VALUE;
        int rt = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i < lt)
                lt = i;
            if (i > rt) {
                rt = i;
            }
        }
        // mid=5. 간격을 5로 해서 말을 배치해보자.
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            // 가지고 있는 제일 첫번째 마구간에 말을 넣는다.
            int count = 1;
            int lastPosition = arr[0];

            // 1 2 4 8 9
            for (int i = 1; i < n; i++) {
                // 마지막에 넣었던 마구간 번호를 기억할 변수=lastPosition=1; 다음 마구간 번호를 뽑는다. 마구간 번호가 lp+mid 간격보다는 넓어야 한다.
                // if(해당 마구간 >= lp+mid) 2>=6, 4>=6, 8>=6 조건에 해당되면 말을 넣고, 말을 넣은 수를 센다. +1;
                if (arr[i] >= lastPosition + mid) {
                    // 다음 수를 뽑고 카운트 수를 확인한다. 해당 사례에서는 말을 2마리밖에 배치하지 못했다.
                    count++;
                    lastPosition = arr[i];
                }
            }
            // 말 수 > 배치한 말 수
            // 배치해야 할 말 마리수 (3마리)와 배치한 마리수 (2마리) 를 비교한다.
            // ***** 계속 놓치는 부분. c == count 뿐 아니라 c < count 의 경우에도 같은 로직.
            // 1 2 4 8 9
            if (c <= count) {
                // 다시 말을 넣으면. 1, 4, 8 -> 카운트 수가 일치한다. 3마리=3마리.
                answer = mid;
                // 조건에는 맞지만 최상의 간격이 있을 수 있으므로 mid 간격을 좀 더 넓혀 본다.
                // 3  3  4  -> mid 를 낮추려면 rt=mid-1;, mid 를 높이려면 lt=mid+1??  mid=3 일때 카운트 수 또 일치. mid 높이기.
                lt = mid + 1;
            } else {
                // 말 수 > 배치한 말 수; 작다는 건 mid 간격이 크다는 얘기이므로 mid 가 5 이상이 되는 건 의미가 없다. 어차피 말을 다 못넣는다.
                // rt 를 mid-1 한다. 1  2  4; mid=2;
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n, c, arr));


    }
}

