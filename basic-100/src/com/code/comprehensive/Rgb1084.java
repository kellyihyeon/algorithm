package com.code.comprehensive;

import java.io.*;

// 출력 시 System.out.println(); 사용 -> 시간 초과 발생 : 메모리 51420, 시간 4017
// 빠른 입출력 사용 -> 메모리 48244, 시간 334
public class Rgb1084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rawRbg = br.readLine().split(" ");
        int red = Integer.parseInt(rawRbg[0]);
        int green = Integer.parseInt(rawRbg[1]);
        int blue = Integer.parseInt(rawRbg[2]);

        int caseOfNum = red * green * blue;

        for (int i = 0; i < red; i++) { // red=2
            for (int j = 0; j < green; j++) {
                for (int k = 0; k < blue; k++) {
                    bw.write(i + " " + j + " " + k + "\n");
                }
            }
        }
        bw.write(String.valueOf(caseOfNum));
        bw.flush();

        bw.close();     // 자원 닫기
        br.close();

    }
}
