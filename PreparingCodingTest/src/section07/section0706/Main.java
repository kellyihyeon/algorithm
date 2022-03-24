package section07.section0706;

/**
 * 부분 집합 구하기 (DFS)
 *
 */
public class Main {

    static int n;
    static int[] ch;    // check 배열 (부분집합으로 할 것이냐(1), 하지 않을 것이냐(0))

    private void DFS(int l) {
        if (l == n + 1) {
            String tmp = "";
            for (int i = 1; i < ch.length; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            // 공집합은 출력하지 않는다.
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {    // 부분 집합으로 사용하느냐 아니냐
            ch[l] = 1;
            DFS(l + 1);

            ch[l] = 0;
            DFS(l + 1);
        }
    }



    public static void main(String[] args) {
        Main M = new Main();

        n = 3;
        ch = new int[n + 1];    // 0번 인덱스는 사용 하지 않는다.
        M.DFS(1);

    }
}
