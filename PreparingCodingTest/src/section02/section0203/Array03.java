package section02.section0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Array03 {
    public static List<String> solution(int n, String[] informA, String[] informB) {
        final String SCISSORS = "1";
        final String ROCK = "2";
        final String PAPER = "3";
        List<String> answer = new ArrayList<>();
        String tmp = "";

        for (int i = 0; i < n; i++) {
            if (informA[i].equals(informB[i])) {
                answer.add("D");
            } else if (informA[i].equals(SCISSORS)) {
                tmp = (informB[i].equals(PAPER)) ? "A" : "B";
                answer.add(tmp);
            } else if (informA[i].equals(ROCK)) {
                tmp = (informB[i].equals(SCISSORS)) ? "A" : "B";
                answer.add(tmp);
            } else if (informA[i].equals(PAPER)) {
                tmp = (informB[i].equals(ROCK)) ? "A" : "B";
                answer.add(tmp);
            }
        }

        return answer;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] informA = br.readLine().split(" ");
        String[] informB = br.readLine().split(" ");

        for (String answer : solution(n, informA, informB)) {
            System.out.println(answer);
        }
    }
}
