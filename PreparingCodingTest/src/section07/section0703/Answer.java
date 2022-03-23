package section07.section0703;

public class Answer {

    private int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Answer A = new Answer();
        System.out.println(A.DFS(6));
    }
}
