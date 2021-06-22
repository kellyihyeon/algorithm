import java.util.Arrays;

public class FindPlayer {

    public String solution(String[] participant, String[] completion) {

        // 오름차순으로 정렬하기
        Arrays.sort(participant);       //{"eden", "kiki", "leo"}
        Arrays.sort(completion);        //{"eden", "kiki"}

        //{"eden", "kiki", "leo"}
        //{"eden", "leo"}

        //["ana", "mislav", "mislav", "stanko"]
        //["ana", "mislav", "stanko"]

        int i;
        String answer = "";

        // 인덱스로 비교하기
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                return answer;
            }
        }
        // 완주자 인덱스만큼 비교 후, 마지막 인덱스가 미완주자일 경우
        answer = participant[i];
        return answer;

    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        FindPlayer solution = new FindPlayer();
        System.out.println(solution.solution(participant, completion));
    }
}
