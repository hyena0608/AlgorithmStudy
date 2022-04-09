package 프로그래머스.자바_코딩테스트_연습.해시_환주하지못한선수;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyena
 */
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> partiMap = new HashMap<>();

        for (String p : participant) {
            partiMap.put(p, partiMap.getOrDefault(p, 0) + 1);
        }

        for (String p : completion) {
            partiMap.put(p, partiMap.getOrDefault(p, 0) - 1);
        }

        for (String p : partiMap.keySet()) {
            if (partiMap.get(p) == 1) answer = p;
        }

        return answer;
    }
}
