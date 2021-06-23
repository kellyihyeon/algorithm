import java.util.Arrays;

public class Average {

    public static void main(String[] args) {
        Average test = new Average();
        int[] arr = {};
        System.out.println("avg = " + test.solution(arr));

        int length = arr.length;
        System.out.println("arr.length = " + length);

//        int[] nothing = null;
//        System.out.println("nothing = " + test.solution(nothing));

    }

    public double solution(int[] arr) {

        // 추가 (null인 경우와 빈 값인 경우)
        if (arr == null || arr.length == 0) {
            return 0;
        }

        double answer = 0;
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        answer = (double)sum / arr.length;

        return answer;
    }

    //다른 사람 코드
    public int getMean(int[] array) {
        return (int) Arrays.stream(array).average().orElse(0);
    }

}
