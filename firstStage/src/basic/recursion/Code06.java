package basic.recursion;

public class Code06 {

    // 순차탐색: 암시적 매개변수
    int search(int[] data, int n, int target) {
        for (int i = 0; i < n; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 매개변수의 명시화: 순차탐색
    int search(int[] data, int begin, int end, int target) {

        if (begin > end) {
            return -1;
        } else if (target == data[begin]) {
            return begin;
        } else {
            return search(data, begin+1, end, target);
        }
    }

    // 순차 탐색: 다른 버전 (1)
    int searchReverse(int[] data, int begin, int end, int target) {

        if (begin > end) {
            return -1;
        } else if (target == data[end]) {
            return end;
        } else {
            return search(data, begin, end-1, target);
        }
    }

    // 순차 탐색: 다른 버전 (2)     ? debugging 필수. -> flow 다시 그리기
    static int searchUsingMid(int[] data, int begin, int end, int target) {

        if (begin > end) {
            return -1;
        } else {
            int middle = (begin+end)/2;
            if (data[middle] == target) {
                return middle;
            }
            int index = searchUsingMid(data, begin, middle - 1, target);
            if (index != -1) {
                return index;
            } else {
                return searchUsingMid(data, middle + 1, end, target);
            }
        }//else
    }

    // 매개변수의 명시화: 최대값 찾기
    int findMax(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        } else {
            return Math.max(data[begin], findMax(data, begin + 1, end));
        }
    }

    // 최대값 찾기: 다른 버전
    static int findMaxUsingMid(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        } else {
            int middle = (begin+end)/2;
            int max1 = findMaxUsingMid(data, begin, middle);
            int max2 = findMaxUsingMid(data, middle + 1, end);
            return Math.max(max1, max2);
        }
    }

    // Binary Search
    public static int binarySearch(String[] items, String target, int begin, int end) {
        if (begin > end) {
            return -1;
        } else {
            int middle = (begin + end) /2;
            int compResult = target.compareTo(items[middle]);
            if (compResult == 0) {
                return middle;
            } else if (compResult < 0) {
                return binarySearch(items, target, begin, middle - 1);
            } else {
                return binarySearch(items, target, middle + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {7, 8, 27, 99};
//        searchUsingMid(data, 1, 4, 9);

        findMaxUsingMid(data, 1, 3);
    }

}
