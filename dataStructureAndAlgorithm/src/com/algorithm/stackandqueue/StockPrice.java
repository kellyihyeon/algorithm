package com.algorithm.stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answers = new StockPrice().solution(prices);
        System.out.println(Arrays.toString(answers));
    }

    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.offer(price);
        }

        int[] answer = new int[prices.length];

        int index = 0;
        boolean reset = false;

        while (queue.size() != 1) {
            Integer poll = queue.poll();
            Integer peek = queue.peek();


            if (poll < peek) {
                answer[index] += 1;

                if (!reset) {
                    for (int i = 0; i <= index; i++) {
                        answer[i] += 1;
                    }
                }
            } else {
                if (!reset) {
                    answer[index] += 1;
                    for (int i = 0; i <= index - 1; i++) {
                        answer[i] += 1;
                    }
                }
                reset = true;
            }

            index++;
        }

        return answer;
    }
}
