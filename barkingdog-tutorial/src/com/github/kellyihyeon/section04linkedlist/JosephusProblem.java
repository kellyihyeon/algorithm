package com.github.kellyihyeon.section04linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class JosephusProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i + 1);
        }

        ListIterator<Integer> lit = numbers.listIterator();

        int count = 0;
        List<String> answers = new LinkedList<>();

        while (numbers.size() != 0) {
            if (!lit.hasNext()) {
                lit = numbers.listIterator();
            }

            Integer next = lit.next();
            count++;
            if (count == k) {
                lit.remove();
                count = 0;
                answers.add(String.valueOf(next));
            }
        }

        System.out.print("<");
        for (int i = 0; i < answers.size(); i++) {
            System.out.print(answers.get(i));
            if (i != answers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}
