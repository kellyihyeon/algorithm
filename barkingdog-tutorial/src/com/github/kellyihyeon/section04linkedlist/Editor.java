package com.github.kellyihyeon.section04linkedlist;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 에디터는 영어 소문자만을 기록할 수 있고, 최대 600,000글자까지 입력할 수 있다.
 * 명령어의 개수 1<=M<=500,000
 * 명령어
 *  L: 커서를 왼쪽으로 한 칸 옮김
 *  D: 커서를 오른쪽으로 한 칸 옮김
 *  B: 커서 왼쪽에 있는 문자를 삭제함
 *  P $: $라는 문자를 커서 왼쪽에 추가함
 *  모든 명령어를 수행한 후 편집기에 입력되어 있는 문자열을 출력하라.
 */
public class Editor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int n = Integer.parseInt(br.readLine());

        List<Character> text = new LinkedList<>();
        for (char c : word.toCharArray()) {
            text.add(c);
        }

        ListIterator<Character> cursor = text.listIterator(text.size());

        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            char operation = command[0].charAt(0);

            if (operation == 'P') {
                char add = command[1].charAt(0);
                cursor.add(add);

            } else if (operation == 'L') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                }
            } else if (operation == 'D') {
                if (cursor.hasNext()) {
                    cursor.next();
                }
            } else if (operation == 'B') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : text) {
            sb.append(c);
        }
        System.out.print(sb);

    }

}
