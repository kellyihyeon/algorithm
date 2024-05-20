package com.algorithm.linearsearch;

import java.util.Arrays;

public class PhoneBook {

    public static void main(String[] args) {
        String[] phoneBook1 = {"119", "97674223", "1195524421"};
        String[] phoneBook2 = {"123", "456", "789"};
        String[] phoneBook3 = {"12", "123", "1235", "567", "88"};

        boolean answer = new PhoneBook().solution2(phoneBook3);
        System.out.println(answer);
    }

    public boolean solution2(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }

        return true;
    }

    // 효율성 실패
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (String phoneNumber1 : phone_book) {
            for (String phoneNumber2 : phone_book) {
                if (phoneNumber1.equals(phoneNumber2)) {
                    continue;
                }
                if (phoneNumber2.startsWith(phoneNumber1)) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
