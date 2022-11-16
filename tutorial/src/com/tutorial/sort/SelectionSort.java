package com.tutorial.sort;

public class SelectionSort {

    public int[] solution(int[] arr) {
        // 10까지 있으니까 총 10번 비교할 건데, 나열된 수 중 제일 작은 수를 찾아서 제일 앞으로 보낸다. min 변수가 필요하고 min 에는 존재하는 큰 값을 넣어놓는다.
        int index = 0, tmp = 0, min = 0;

        for (int i = 0; i < arr.length; i++) {
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                // min > 비교 num -> min = 비교 num
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;      // 제일 앞에 있는 숫자와 최소값을 발견한 위치를 스와핑 해야하므로 index = j
                }
            }
            // 제일 앞에 있는 숫자와 최소값의 위치를 스와핑
            tmp = arr[i];
            arr[i] = min;
            arr[index] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        int[] solution = selectionSort.solution(new int[]{1, 10, 5, 8, 7, 6, 4, 3, 2, 9});
        for (int answer : solution) {
            System.out.print(answer + " ");
        }
    }

}
