package section02.section0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Array01 {
    public static List<Integer> solution(int n, String str) {
        List<Integer> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        final String[] tmp = str.split(" ");    // 6개

        for (int i = 0; i < n; i++) {
            final int tmpInt = Integer.parseInt(tmp[i]);    // '7 '3 '9 '5 '6 '12
            list.add(tmpInt);       // list = '7 '3 '9 '5 '6 '12
            if (answer.isEmpty()) {   // 첫 번째 수는 무조건 출력한다.
                answer.add(tmpInt);   // answer = 7
            } else {
                if (list.get(i - 1) < tmpInt) {
                    answer.add(tmpInt); // answer = 9 6 12
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        final String str = br.readLine();

        for (Integer integer : solution(n, str)) {
            System.out.print(integer + " ");
        }
    }
}
