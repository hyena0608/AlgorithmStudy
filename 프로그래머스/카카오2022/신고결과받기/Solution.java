package 프로그래머스.카카오2022.신고결과받기;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> mailMap = new HashMap<>();
        Map<String, Integer> reportedMap = new HashMap<>();

        for (String id : id_list) {
            reportedMap.put(id, 0);
            mailMap.put(id, 0);
        }

        List<String> distinctReport = Arrays.stream(report).distinct().collect(Collectors.toList());

        for (String r : distinctReport) {
            String[] splitedReport = r.split(" ");
            reportedMap.put(splitedReport[1], reportedMap.getOrDefault(splitedReport[1], 0) + 1);
        }

        for (String r : distinctReport) {
            String[] splitedReport = r.split(" ");
            if (reportedMap.get(splitedReport[1]) >= k) {
                mailMap.put(splitedReport[0], mailMap.getOrDefault(splitedReport[0], 0) + 1);
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailMap.get(id_list[i]);
        }

        return answer;
    }
}
