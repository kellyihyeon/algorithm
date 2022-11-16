package section06.section0607;

import java.util.Scanner;

// 좌표 정렬
// n개의 좌표를 정렬하여 출력하라.
// x 값으로 정렬하고, x 값이 같으면 y 값으로 정렬하라.
public class Main {

    private void solution(int n, int[][] arr) {
        //5
        //2 7   00 01
        //1 3   10 11
        //1 2   20 21
        //2 5   30 31
        //3 6   40 41
        // -> arr[][] 를 먼저 x 값으로 정렬을 하자.
        // 출력 확인
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        int[][] answer = new int[n][2];
        // x 값의 좌표는? 00, 10, 20, 30, 40, 50 -> x 값의 좌표를 기준으로 x,y 를 한 세트로 같이 이동시켜서 정렬한다.
        // x 정렬, y 정렬 하기에는 x 랑 y 값이 제각각 떨어져서 움직이는데 이걸 어떻게 기억하고 있지?
        // 한 줄씩 비교하는 건 어떨까? 버블 정렬처럼. -> 이건 아닌데, ... 앞에 숫자만 비교하고 옮길 땐 통으로 같이 옮기는 방법이 없나?
        // 00 이랑 10 이랑 비교해서 작은 숫자가 앞으로 간다. (자리를 바꾼다) 10이 작으니까 00과 10 자리바꾸고, 01과 11 자리 바꾼다.
        // 이걸 언제까지 해야 하는가? 정렬이 완벽히 됐을 때까지.
        // 2 1 1 2 3 을 정렬한다고 생각하자.
        // 1 1 2 2 3
        for (int i = 0; i < n-1; i++) { // 0 1 2 3
            for (int j = 0; j < 1; j++) {
                if (arr[i][j] > arr[i + 1][j + 1]) {
                    answer[i][j] = arr[i + 1][j];           // 00 -> 1
                    answer[i][j + 1] = arr[i + 1][j + 1];   // 01 -> 3
                    answer[i + 1][j] = arr[i][j];           // 10 -> 2
                    answer[i + 1][j + 1] = arr[i][j + 1];   // 11 -> 7
                } else {  //그대로
                    answer[i][j] = arr[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
        // for 문으로 x 를 조정해서, y 는 어떻게 같이 움직이지? 00의 짝은 01, 10의 짝은 11, 20의 짝은 21... i 와 j 의 수가 같은 지점.
        // x 가 정렬이 되면 (잘 정렬되었다고 가정), y 값을 기준으로 정렬하면 제일 작은 수가 앞에 오겠네. -> x 의 값이 같을 때 y 값을 정렬해야 한다. (조건 필요)
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        M.solution(n, arr);
    }

}
