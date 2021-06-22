import java.util.ArrayList;
import java.util.List;

public class MockTest {

    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int ansA = 0, ansB = 0, ansC = 0;

        // [1,2,3,4,5]
        for (int i = 0; i < answers.length; i++) {
            if (a[i] == answers[i]) {
                ansA++;
            }
            if (b[i] == answers[i]) {
                ansB++;
            }
            if (c[i] == answers[i]) {
                ansC++;
            }
        }//for
//        System.out.println(ansA);
//        System.out.println(ansB);
//        System.out.println(ansC);

        int max = ansA;
        List<Integer> list = new ArrayList<>();

        if (ansB > max) {
            max = ansB;
        }
        if (ansC > max) {
            max = ansC;
        }

        //max 중복    list={1,2,3}
        if (max == ansA) {
            list.add(1);
        }
        if (max == ansB) {
            list.add(2);
        }
        if (max == ansC) {
            list.add(3);
        }

        int[] answer = {};
        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
//            System.out.println(answer[i]);
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
