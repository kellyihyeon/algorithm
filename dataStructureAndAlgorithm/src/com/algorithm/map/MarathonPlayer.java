package com.algorithm.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * 마라톤 선수 중 한명은 완주하지 못한다.
 * 참가자와 완주자 명단을 비교하여 완주하지 못한 선수를 찾아내라.
 * 단, 참가자 중에는 동명이인이 있을 수 있다.
 */
public class MarathonPlayer {

    // 이름과 인원 수를 key-value 한쌍으로 가지고 있는 Map 을 사용해서 참가자 명단을 만들자.
    // 참가자 명단에서 완주자 이름을 기준으로 value 를 -1씩 해준다.
    // value 가 0이 되면 참가자 명단에서 삭제한다.
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participants = new Hashtable<>();

        // 참가자 명단 만들기
        for (String name : participant) {
            if (participants.containsKey(name)) {
                participants.put(name, (participants.get(name) + 1));
            } else {
                participants.put(name, participants.getOrDefault(name, 1));
            }
        }

        // 완주자 -1해서 제외해주기
        for (String compName : completion) {
            if (participants.containsKey(compName)) {
                participants.put(compName, participants.get(compName) - 1);
                // 동명이인이 아니라면 0 -> 참가자 명단에서 삭제하기
                if (participants.get(compName) == 0) {
                    participants.remove(compName);
                }
            }
        }
        // 참가자 명단에 남아있는 사람 = 완주하지 못한 사람
        answer = participants.keySet().stream().findFirst().get();

        return answer;
    }
}
