//package 이코테.Greedy.무지의먹방라이브;
//
//import java.util.Arrays;
//
//public class Solution {
//
//    public int solution(int[] food_times, long k) {
//
//        long count = k;
//
//        Arrays.sort(food_times);
//        int foodLength = food_times.length;
//        int minIndex = 0;
//        int min = food_times[minIndex];
//
//        int curr = 0;
//        int minusCount = 0;
//        while (true) {
//            if (count - min < 0) break;
//            count -= min;
//            min
//            int leftCount = foodLength % min;
//            curr = leftCount;
//
//            minusCount = min;
//
//            while (food_times[minIndex] == min) {
//                minIndex++;
//            }
//            min = food_times[minIndex];
//        }
//
//
//
//
//
//        int answer = 0;
//        return answer;
//    }
//}
