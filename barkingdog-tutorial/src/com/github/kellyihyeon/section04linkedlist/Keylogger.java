package com.github.kellyihyeon.section04linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * 키로거는 사용자가 키보드를 누른 명령을 모두 기록한다.
 * 비밀번호를 입력한 길이 L: 1<=L<=1,000,000
 * 키보드로 입력한 키: 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표
 * 백스페이스 - : 커서의 바로 앞에 글자가 존재한다면, 그 글자를 삭제
 * 화살표 < > : 커서의 위치가 맨 앞 또는 맨 뒤가 아니라면, 왼쪽 또는 오른쪽으로 1만큼 이동
 *
 */
public class Keylogger {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String input = br.readLine();
            char[] command = input.toCharArray();

            List<Character> text = new LinkedList<>();
            int index = 0;
            for (char c : command) {
                if (c == '<') {
                    if (index != 0) {
                        index--;
                    }
                } else if (c == '>') {
                    if (index != text.size()) {
                        index++;
                    }
                } else if (c == '-') {
                    if (index != 0) {
                        text.remove(index - 1);
                        index--;
                    }
                } else {
                    text.add(index, c);
                    index++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character character : text) {
                sb.append(character);
            }

            System.out.println(sb);
        }
    }
}
