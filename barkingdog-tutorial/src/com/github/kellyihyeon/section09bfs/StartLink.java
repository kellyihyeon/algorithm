package com.github.kellyihyeon.section09bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 총 F층, 현재 위치 S층, 사무실은 G층,
 * U: up, D: down
 */
public class StartLink {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int full = Integer.parseInt(line.split(" ")[0]);
        int current = Integer.parseInt(line.split(" ")[1]);
        int target = Integer.parseInt(line.split(" ")[2]);
        int up = Integer.parseInt(line.split(" ")[3]);
        int down = Integer.parseInt(line.split(" ")[4]);

        int[] distance = new int[full + 1];
        distance[current] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            int nextUp = now + up;
            int nextDown = now - down;

            for (int next : new int[]{nextUp, nextDown}) {
                if (next > full || next <= 0 || distance[next] != 0) continue;

                distance[next] = distance[now] + 1;
                queue.offer(next);
            }

        }

        if (distance[target] != 0) {
            System.out.println(distance[target] - 1);
        } else {
            System.out.println("use the stairs");
        }
    }

}
