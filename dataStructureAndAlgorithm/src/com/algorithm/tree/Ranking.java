package com.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ranking {

    class Player {
        int number;
        List<Player> links = new LinkedList<>();
        int win = 0;
        int lose = 0;
        boolean visit = false;

        public Player(int number) {
            this.number = number;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3},{4, 2},{3, 2},{1, 2},{2, 5}};
        int answer = new Ranking().solution(n, results);
        System.out.println("answer = " + answer);
    }

    public int solution(int n, int[][] results) {
        List<Player> players = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(i + 1));
        }

        for (int[] result : results) {
            Player winner = players.get(result[0] - 1);
            Player loser = players.get(result[1] - 1);

            winner.links.add(loser);
        }

        for (Player winner : players) {
            for (Player node : players) {
                node.visit = false;
            }

            Queue<Player> queue = new LinkedList<>();
            queue.offer(winner);

            while (!queue.isEmpty()) {
                Player now = queue.poll();

                for (Player loser : now.links) {
                    if (loser.visit) {
                        continue;
                    }
                    loser.visit = true;

                    winner.win += 1;
                    loser.lose += 1;

                    queue.offer(loser);
                }
            }

        }

        int answer = 0;
        for (Player player : players) {
            if (player.win + player.lose == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
