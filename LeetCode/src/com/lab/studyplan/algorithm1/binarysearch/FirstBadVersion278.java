package com.lab.studyplan.algorithm1.binarysearch;

public class FirstBadVersion278 {

    boolean isBadVersion(int version) {
        // VersionControl 에 정의된 메서드
        return true;
    }

    public int binary(int low, int high) {


        if(low < high) {
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)) {
                return binary(low, mid);
            } else {
                return binary(mid+1, high);
            }
        }
        return low;
    }
    public int firstBadVersion(int n) {

        return binary(1, n);
    }



    public static void main(String[] args) {

    }
}
