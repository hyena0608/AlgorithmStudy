package 프로그래머스.해시_전화번호목록;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyena
 */
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> phoneMap = new HashMap<>();

        for (String phone : phone_book) {
            phoneMap.put(phone, 1);
        }

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (phoneMap.containsKey(phone.substring(0, i)))
                    return false;
            }
        }

        return true;
    }
}