package com.lab.studyplan.algorithm1.binarysearch;

public class FirstBadVersion278 {

    boolean isBadVersion(int version) {
        // first bad is 4
        if (version < 4) {
            return false;
        }
        return true;
    }

    public int binary(int low, int high) {
        if(low < high) {
            int mid = low + (high - low)/2;

            if(isBadVersion(mid)) {
                return binary(low, mid);
            } else {
                return binary(mid + 1, high);
            }
        }
        return low;
    }

    // 1. 재귀로 푸는 방식
    public int firstBadVersion(int n) {

        return binary(1, n);
    }

    // 2. 재귀 아닌 방식
    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        final FirstBadVersion278 F = new FirstBadVersion278();
        System.out.println(F.firstBadVersion(5));
    }
}
