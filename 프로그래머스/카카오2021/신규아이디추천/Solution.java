package 프로그래머스.카카오2021.신규아이디추천;

class Solution {
    public static void main(String[] args) {
        Solution S = new Solution();
        S.solution("z-+.^.");
    }
    public String solution(String new_id) {
        new_id = changeToLowerCase(new_id);
        new_id = removeUnnecessaryChar(new_id);
        new_id = changeMoreThanTwoFullStopToOne(new_id);
        new_id = removeIfFullStopExistsAtStartEndIndex(new_id);
        new_id = addaIfStringEmpty(new_id);
        new_id = removeStringOver15IdxAnd15IfLastFullStop(new_id);
        new_id = makeStringOverThree(new_id);
        return new_id;
    }

    private String changeToLowerCase(String new_id) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : new_id.toCharArray()) {
            stringBuffer.append(Character.toLowerCase(c));
        }
        return stringBuffer.toString();
    }

    private String removeUnnecessaryChar(String new_id) {
        return new_id.replaceAll("[^a-z0-9-_.]", "");
    }

    private String changeMoreThanTwoFullStopToOne(String new_id) {
        char[] new_id_chars = new_id.toCharArray();
        int fullStopCount = 0;
        for (int i = 0; i < new_id_chars.length; i++) {
            if (new_id_chars[i] == '.') {
                if (fullStopCount == 0) {
                    fullStopCount++;
                } else if (fullStopCount >= 1) {
                    new_id_chars[i] = ' ';
                }
            } else {
                fullStopCount = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char new_id_char : new_id_chars) {
            if (new_id_char != ' ')
                stringBuilder.append(new_id_char);
        }
        return stringBuilder.toString();
    }

    private String removeIfFullStopExistsAtStartEndIndex(String new_id) {
        char[] new_id_chars = new_id.toCharArray();
        if (new_id_chars[0] == '.') {
            new_id_chars[0] = ' ';
        }
        if (new_id_chars[new_id_chars.length - 1] == '.') {
            new_id_chars[new_id_chars.length - 1] = ' ';
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char new_id_char : new_id_chars) {
            if (new_id_char != ' ')
                stringBuilder.append(new_id_char);
        }
        return stringBuilder.toString();
    }

    private String addaIfStringEmpty(String new_id) {
        if (new_id.length() == 0) {
            new_id = "a";
        }
        return new_id;
    }

    private String removeStringOver15IdxAnd15IfLastFullStop(String new_id) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] new_id_chars = new_id.toCharArray();
        if (new_id.length() >= 16) {
            for (int i = 15; i < new_id_chars.length; i++) {
                new_id_chars[i] = ' ';
            }
            if (new_id_chars[14] == '.') {
                new_id_chars[14] = ' ';
            }
        }
        for (char new_id_char : new_id_chars) {
            if (new_id_char != ' ')
                stringBuilder.append(new_id_char);
        }
        return stringBuilder.toString();
    }

    private String makeStringOverThree(String new_id) {
        String lastString = new_id.substring(new_id.length() - 1);
        while (new_id.length() <= 2) {
            new_id += lastString;
        }
        return new_id;
    }
}