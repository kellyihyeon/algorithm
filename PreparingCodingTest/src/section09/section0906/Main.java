package section09.section0906;

import java.util.*;

/**
 * 친구인가? (서로소 집합: 두 집합이 공통 집합이 없으면 서로소 집합이다.)
 * 1 -> 2 -> 3 -> 4
 * 두 학생이 친구면 YES, 아니면 NO
 * 학생 수 최대 1,000명
 * 1번과 4번은 2번 3번을 통해서 친구관계가 된다. (point)
 * 간선으로 연결이 되면 친구이고, 그렇지 않으면 친구가 아니다.
 *
 * 이해 했는데, 어떻게 이렇게 코드를 짤 생각을 하지??? 대단하다...
 */
public class Main {

    public static int[] unf;    // 집합을 표현


    public static int Find(int v) {
        if (v == unf[v]) {
            return unf[v];  // v번 학생의 집합 번호를 리턴
        } else {
            unf[v] = Find(unf[v]);  // [4 4 4 5 5 6 7 8 9] 저장 받고 unf 에 리턴 받은 값을 저장 (경로 압축)
            return  unf[v];
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) {
            unf[fa] = fb;   //[2 3 4 5 5 6 7 8 9] 1번 학생의 집합 번호를 표시
        }
    }


   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);

       int n = scanner.nextInt();
       int m = scanner.nextInt();

       unf = new int[n + 1];    // 서로소 집합 표현
      for (int i = 1; i <= n; i++) {
           unf[i] = i;  // [1 2 3 4 5 6 7 8 9] 학생 인덱스를 이용해서 집합 번호 지정
       }

       for (int i = 0; i < m; i++) {
           int a = scanner.nextInt();
           int b = scanner.nextInt();

           Union(a, b); // a와 b는 친구니까 같은 집합으로 만든다.
       }

       int a = scanner.nextInt();
       int b = scanner.nextInt();
       int fa = Find(a);
       int fb = Find(b);

       if (fa == fb) {
           System.out.println("YES");
       } else {
           System.out.println("NO");
       }

   }

}
