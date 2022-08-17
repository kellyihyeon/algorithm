package arraysandhashing;

public class ProductOfArrayExceptSelf238 {


    public int[] productExceptSelf(int[] nums) {
        final int N = nums.length;

        int[] leftProducts = new int[N];
        int[] rightProducts = new int[N];
        int[] answer = new int[N];

        leftProducts[0] = 1;
        rightProducts[N - 1] = 1;

        for (int i = 1; i < N; i++) {
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
        }

        for (int i = 0; i < N; i++) {
            answer[i] = leftProducts[i] * rightProducts[i];
        }

        return answer;
    }
}
