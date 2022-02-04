package section05.section0503;

import java.util.Scanner;
import java.util.Stack;

// ** 시간 줄이는 법: 2차원 배열 문제 나오면 2차원 배열의 자리를 전부 표시하고 규칙찾기 (i와 j의 위치를 반대로 잡아서 초반에 시간을 소요함)
// ** 효율적으로 코드 짜기: 1.배열에서 전부 다 꺼내려할 때는 for each 문을 써서 간결하게 표시한다. (읽기 좋음)
//                       2. for 문 안에서 변수를 이해하기 쉬운 이름으로 짓는다. 예: i -> position
//                       3. 스택이 비었는지 확인할 때 if (!basket.isEmpty() && basket.peek() == board[j][moves[i] - 1]) 한번에 비교하면
//                          if 에 해당하지 않는 경우 else 문을 한번만 써서 코드를 짤 수 있다.  basket.push(board[j][moves[i] - 1]);
public class Main {
    // 바구니에 쌓이는 인형 = 4 (3 (1 1) 3) 2 4 -> 4개 인형이 터져서 없어진다.
    // 자연수 n, n*n board 배열 (2차원 배열), moves 배열의 길이 m, moves 배열 (1차원 배열)이 주어진다.
    // 인형뽑기 기계에 인형들이 2차원 배열 1칸 크기에 맞게 하나씩 쌓여있다. (0은 인형이 없음을 의미)
    // moves 배열은 인형을 뽑을 크레인의 위치를 의미한다. 크레인은 맨 위에 쌓여 있는 인형을 바구니에 옮겨 담는다.
    // 바구니에 인형들을 옮겨 담을 때 같은 인형을 연속해서 쌓으면 이 같은 인형 2개가 터져 없어진다.
    // 인형 뽑기가 끝난 후 터져서 없어진 인형의 개수를 출력하라.

    private int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        // 크레인의 위치는 인형을 뽑을 위치를 말한다. 이는 즉 i의 위치이다.
        // 바구니가 필요한데, 이 바구니는 인형을 쌓아놓고 맨 위의 인형부터 꺼내는 방식이다. (stack 이용)
        Stack<Integer> basket = new Stack<>();
        // 바구니에서 제일 위에 있는 인형을 살펴보고 이제 막 넣으려는 인형과 번호를 비교해본 뒤 같은 인형이면 pop 시켜서 없애버린다.
        // 같은 인형일 때 카운트는 +2 증감한다. 그리고 최종 카운트 수를 출력한다.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 인형 뽑기 통의 숫자가 0이라는 건 인형이 없다는 뜻이므로 크레인 위치 -1 = j의 위치. i가 0 ~ n일 때 순서대로 뒤져본다.
                // stack 바구니에 인형을 push 할 때 선행돼야 할 액션: stack 이 빈 stack 이 아니라면 stack 맨 위에 있는 인형의 값과 push 하려는 값을 비교해야 한다.
                if (board[j][moves[i] - 1] != 0) {
                    // 스택 바구니에 인형이 들어있을 때 -> 같은 인형인지 아닌지 비교하는 작업이 필요하다.
                    if (!basket.isEmpty()) {
                        // 두 값이 같으면 count +2를 하고 stack 바구니에서 인형을 제거한다.
                        if (basket.peek() == board[j][moves[i] - 1]) {
                            answer += 2;
                            basket.pop();
                            // 같은 인형이 아니라면 인형을 넣어야지
                        } else {
                            basket.push(board[j][moves[i] - 1]);
                        }
                        // 스택 바구니에 인형이 하나도 없을 때
                    } else {
                        basket.push(board[j][moves[i] - 1]);
                    }
                    // 공통 작업: 스택 바구니에 인형이 있든 없든, 인형 뽑기 통에서 꺼낸 인형의 자리는 0으로 표기해 인형이 없음을 표시해야한다.
                    board[j][moves[i] - 1] = 0;
                    // 맨 위에 있는 인형만 확인하면 되므로 다음 인형을 살펴보지 못하게 j for 문을 빠져나간다.
                    break;
                }

            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Main M = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }

        System.out.println(M.solution(n,board,m,moves));
    }

}
