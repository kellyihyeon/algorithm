package com.algorithm.map;

import java.util.HashMap;
import java.util.Map;

public class MarathonPlayer {

    public String answer(String[] participant, String[] completion) {
        Map<String, Integer> players = new HashMap<>();

        for (String name : participant) {
            players.put(name, players.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            int n = players.get(name) - 1;
            if (n == 0) {
                players.remove(name);
            } else {
                players.put(name, n);
            }
        }

        return players.keySet().iterator().next();
    }

    public String solution2(String[] participant, String[] completion) {
        Map<String, Integer> completionPlayer = new HashMap<>();
        Map<String, Integer> player = new HashMap<>();

        String answer = null;
        for (String name : participant) {
            player.put(name, (player.getOrDefault(name, 0)) + 1);
        }

        for (String name : completion) {
            completionPlayer.put(name, (completionPlayer.getOrDefault(name, 0)) + 1);
        }

        for (Map.Entry<String, Integer> playerMap : player.entrySet()) {
            String name = playerMap.getKey();

            if (!player.get(name).equals(completionPlayer.get(name))) {
                answer = name;
            }
        }

        return answer;
    }

    public String solution(String[] participant, String[] completion) {
        String answer = null;
        Map<String, Integer> players = new HashMap<>();

        for (String name : completion) {
            players.put(name, players.getOrDefault(name, 0) + 1);
        }

        for (String name : participant) {
            Integer numberOfPlayer = players.get(name);
            if (numberOfPlayer == null) {
                answer = name;
            } else if (numberOfPlayer == 1) {
                players.remove(name);
            } else {
                players.put(name, numberOfPlayer - 1);
            }
        }

        return answer;
    }
}
