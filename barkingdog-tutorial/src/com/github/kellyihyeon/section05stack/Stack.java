package com.github.kellyihyeon.section05stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 정수를 저장하는 스택을 구현하고 입력으로 주어지는 명령을 처리할 것
 * 명령
 *    1. push(x)
 *    2. pop
 *    3. size
 *    4. empty
 *    5. top
 * 명령의 수 n: 1<=n<=10,000
 */
public class Stack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> stack = new LinkedList<>();

        while (n-- > 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            String command = token.nextToken();

            switch (command) {
                case "push":
                    int num = Integer.parseInt(token.nextToken());
                    stack.add(num);
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.remove(stack.size() - 1));
                    }
                    break;

                case "top":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.get(stack.size() - 1));
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
            }
        }

    }
}
