package com.code.comprehensive;

import java.io.*;

public class MultipleOfThree1088 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        // 방법 1
        // 메모리 11168, 시간 67
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0) {
                continue;
            } else {
                System.out.print(i + " ");
            }
        }//for

        // 방법 2
        // 메모리 11156, 시간 60
        for (int i = 1; i <= num; i++) {
            if (i % 3 != 0) {
                System.out.print(i + " ");
            }
        }//for


        // 방법 3
        // 메모리 11256, 시간 70
        for (int i = 1; i <= num; i++) {
            if (i % 3 != 0) {
                bw.write(i + " ");
            }
        }//for

        bw.flush();
        bw.close();
        br.close();
    }
}
