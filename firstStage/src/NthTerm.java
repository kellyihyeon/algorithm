import java.util.Arrays;

class NthTerm {
    public int[] solution(int[] array, int[][] commands) {

        // array = [1, 5, 2, 6, 3, 7, 4]
        // commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
        // answer = [5, 6, 3]

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int start = commands[i][0];
            int end = commands[i][1];
            int len = (end - start) + 1;
//            System.out.println("len = " + len);

            int[] temp = new int[len];
            int a = 0;

            for (int j = start-1; j < end; j++) {
                temp[a++] = array[j];
            }
            Arrays.sort(temp);
//            System.out.println("sort temp = " + Arrays.toString(temp));
            int k = commands[i][2];

            answer[i] = temp[k - 1];
//            System.out.println("answer = " + answer[i]);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        NthTerm test = new NthTerm();
        int[] answer = test.solution(array, commands);
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
