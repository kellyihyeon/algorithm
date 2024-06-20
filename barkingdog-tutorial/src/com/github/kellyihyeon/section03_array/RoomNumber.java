package com.github.kellyihyeon.section03_array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 숫자 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
 * 다솜이의 방 번호 N이 주어졌을 때, 방 번호를 만들 수 있는 필요한 숫자 세트의 개수의 최솟값을 출력하라.
 * 조건: 6과 9는 서로 뒤집어서 이용할 수 있다.
 *
 */
public class RoomNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roomNumber = scanner.nextInt();

        int[] numbers = new int[10];
        while (roomNumber > 0) {
            int remainder = roomNumber % 10;
            if (remainder == 6) {
                remainder = 9;
            }

            numbers[remainder] += 1;
            roomNumber = roomNumber / 10;
        }

        numbers[9] = numbers[9] / 2 + numbers[9] % 2;

        Arrays.sort(numbers);
        System.out.println(numbers[9]);
    }
}
