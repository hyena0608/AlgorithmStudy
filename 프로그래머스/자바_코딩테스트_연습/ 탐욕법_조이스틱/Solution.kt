//package 프로그래머스.자바_코딩테스트_연습.` 탐욕법_조이스틱`
//
///**
// * @author hyena
// */
//class Solution {
//    public int solution(String name) {
//        int answer = 0;
//
//        for (char c : name.toCharArray()) {
//            if (c <= 'N') {
//                answer += (int) c - 65;
//            } else {
//                answer += Math.abs((int) c - 91);
//            }
//        }
//
//        int firstIdx = 0;
//        for (int i = 0; i < name.length(); i++) {
//            if (name.charAt(i) != 'A') {
//                firstIdx = i;
//                break;
//            }
//        }
//
//        int lastIdx = 0;
//        for (int i = name.length() - 1; i >= 0; i--) {
//            if (name.charAt(i) != 'A') {
//                lastIdx = i;
//                break;
//            }
//        }
//
//        // System.out.println(firstIdx + " " + lastIdx);
//        int min = Math.min(2 * firstIdx + name.length() - lastIdx, lastIdx);
//        System.out.println(min);
//        if (lastIdx == 0)
//            answer += 0;
//        else
//            System.out.println(answer);
//            System.out.println(Math.min(min, name.length() - firstIdx));
//            answer += Math.min(min, name.length() - firstIdx);
//
//        return answer;
//    }
//}