package section06.section0606;

import java.util.Scanner;

/**
 * 반에 n 명의 학생이 있고, 반 번호를 부여하기 위해 이들을 키가 작은 순서대로 줄을 세웠다.
 * 철수는 짝꿍보다 키가 크지만, 앞 번호가 받고 싶어 짝꿍과 자리를 바꿨다.
 * 서있는 순서대로 학생들의 키 정보가 arr 배열에 담겨 주어진다. 이때 철수의 번호와 짝꿍의 번호를 출력하라.
 *
 * *** arr 을 복사해서 정렬한 뒤 두 배열의 원소값을 비교해서 위치를 찾는 방법도 있다.(간단)
 */
public class Main {

    private int[] solution(int n, int[] arr) {
        int[] answer = new int[2];
        int height = 0;
        // 서있는 순서대로 번호가 부여된다. 키 순서대로 서있으니 배열은 정렬이 되어있다.
        // 철수는 짝꿍보다 키가 큰데 자리를 바꿨기 때문에 배열에 정렬이 어긋나는 지점이 있다. 이 지점을 찾아야 한다.
        // 120 130 150 150 130 150
        // 다시 정렬할 필요없이 정렬이 어긋나는 두 지점의 인덱스를 찾으면 된다.
        // 1. 짝꿍의 인덱스를 찾아보자.
        // n-1까지 돌면서 인접한 두 원소를 비교한다. (앞 원소: a, 뒤 원소: b)
        for (int i = 0; i < n - 1; i++) {
            // b가 a보다 작은 위치를 찾는다. (인덱스0부터 시작했다면 인덱스+1 한 지점, 인덱스1부터 시작했다면 해당 인덱스 지점)
            //  #두 원소가 같은 경우는 패스 해야 한다. -> b 가 a보다 작은지 물어보면 같은 경우는 저절로 패스 됨.
            if (arr[i] > arr[i + 1]) {
                // 짝꿍의 인덱스+1 을 해서 정답 배열에 넣는다. (정답 배열의 두번째에 넣는다.)
                answer[1] = (i + 1) + 1;
                // 짝꿍의 인덱스로 짝궁 키를 저장해 놓자. (height = 130)
                height = arr[i + 1];
            }
        }
        // 2. 철수의 인덱스를 찾아보자.
        // 짝꿍이 원래 어느 자리에 있어야 했는지를 찾는다. 짝꿍의 키 (130)
        for (int i = 0; i < n; i++) {
            // 처음 위치부터 비교하여 짝꿍의 키보다 큰 원소가 있는 위치를 찾는다. height 보다 해당 원소가 큰지 비교.
            if (arr[i] > height) {
                // 해당 되는 인덱스+1 해서 철수의 위치를 정답 배열에 넣는다. (인덱스는 0부터 시작하므로 위치를 출력할 시 +1을 해야함) (정답 배열의 첫번째에 넣는다.)
                answer[0] = i + 1;
                // ** 놓친 점: 큰 원소가 나오면 break 를 해야 뒤 원소를 찾지 않는다. 안멈추면 원소를 다 비교해서 결국 최대값의 위치를 출력한다.
                break;
            }
        }

        return answer;
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
