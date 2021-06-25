import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePrintAnIntArray {

    public int[] solution(long n) {

        // 1. long -> string 으로 형변환 (n 의 길이를 얻기 위해서)
        String transToString = Long.toString(n);
        System.out.println("transToString = " + transToString);
        int len = transToString.length();

        // 2. String 역으로 저장. transToString = 345 -> 5,4,3
        List<Integer> list = new ArrayList<>();

        for (int i = len-1; i > -1; i--) {                          // i = 2, 1, 0
            char charAt = transToString.charAt(i);                  // char 5, 4, 3
            int num = Integer.parseInt(String.valueOf(charAt));     // int 5, 4, 3
            list.add(num);       //5, 4, 3
        }
        System.out.println("list = " + list);

        // 3. list -> int[]
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = list.get(i);
        }

        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        long n = 345;
        ReversePrintAnIntArray rv = new ReversePrintAnIntArray();
        rv.solution(n);
    }
}
