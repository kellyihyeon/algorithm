package section07.section0701;

/**
 * 재귀함수: 자기 자신을 호출하는 함수
 * 스택 프레임
 */
public class Answer {

    private void DFS(int n) {
        if (n == 0) {
            return; // 함수 종료
        } else {
            DFS(n - 1);
            System.out.print(n + " ");
        }

    }


    public static void main(String[] args) {
        Answer A = new Answer();
        A.DFS(3);
    }
}
