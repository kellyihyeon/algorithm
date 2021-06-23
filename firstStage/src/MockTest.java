import java.util.ArrayList;
import java.util.List;

public class MockTest {

    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // edit
        int[] arr = new int[3];     // {a가 맞힌 갯수, b가 맞힌 갯수, c가 맞힌 갯수}

        // edit
        for (int i = 0; i < answers.length; i++) {
            if (a[i % a.length] == answers[i]) {
                arr[0]++;
            }
            if (b[i % b.length] == answers[i]) {
                arr[1]++;
            }
            if (c[i % c.length] == answers[i]) {
                arr[2]++;
            }
        }//for

        //최댓값 찾기 (edit)
        int max = Math.max(Math.max(arr[0], arr[1]), arr[2]);
        List<Integer> list = new ArrayList<>();

        //max 중복    list={1,2,3}
        if (max == arr[0]) {
            list.add(1);
        }
        if (max == arr[1]) {
            list.add(2);
        }
        if (max == arr[2]) {
            list.add(3);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        MockTest test = new MockTest();
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1,3,2,4,2};

        test.solution(answers);

    }

}
