package com.github.kellyihyeon.section03_array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1학년부터 6학년까지 학생들이 묵을 방 배정하기.
 * 원칙은 1.같은 성별끼리, 2.한 방에는 같은 학년끼리, 3.한 방에 한 명만 배정하는 것 가능.
 * 한 방에 배정할 수 있는 최대 인원 수 K가 주어졌을 때, 방 배정을 위해 필요한 방의 최소 개수를 구하라.
 * 입력 - 수학여행 참가 학생 수 n
 *       한 방에 배정할 수 있는 최대 인원 수 k
 *       학생의 성별 s(여자0, 남자1)와 학년 y이 공백을 기준으로 주어짐 (예: 1 1 -> 남학생-1학년)
 */
public class RoomAssignment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int max = input[1];

        int[][] students = new int[7][2];

        // 학생을 '학년-성별' 로 데이터 취합하기
        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            students[line[1]][line[0]]++;
        }

        // 방 개수 구하기
        int answer = 0;
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < 2; j++) {
                answer += students[i][j] / max;

                if (students[i][j] % max > 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    // 처음에 풀었던 방식
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int max = input[1];

        int[][] students = new int[7][2];

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int gender = line[0];
            int grade = line[1];
            int[] student = students[grade];
            if (gender == 0) {
                student[0] += 1;
            } else {
                student[1] += 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < students.length; i++) {
            int[] student = students[i];
            int female = student[0];
            int male = student[1];

            if (female % max == 0) {
                answer += female / max;
            } else {
                answer += female / max + 1;
            }

            if (male % max == 0) {
                answer += male / max;
            } else {
                answer += male / max + 1;
            }
        }

        System.out.println(answer);
    }
}
