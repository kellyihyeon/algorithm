package section07.section0702;

/**
 * 재귀 함수로 풀기
 * 11 을 2진수로 바꾼다는 것은? 2로 계속 나누는 것.
 * 2로 나누고 몫과 나머지가 얼마인지 본다.
 * 몫이 0이 되면 멈춘다.
 */
public class Answer {

    private void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            // n/2 = 몫 5, 나머지 1
            DFS(n / 2); // 5...1, 2...1, 1...0, 0...1
            System.out.print(n % 2);
        }


    }

    public static void main(String[] args) {
        Answer A = new Answer();
        A.DFS(11);
    }
}
