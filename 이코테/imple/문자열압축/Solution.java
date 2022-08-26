    package 이코테.imple.문자열압축;


    public class Solution {

        public int solution(String s) {

            int answer = Integer.MAX_VALUE;
            int length = s.length();
            for (int zip = 1; zip <= length / 2; zip++) {
                String sub = s.substring(0, zip);
                int zipCount = 0;
                int perZipCount = 0;

                for (int idx = 0; idx < length; idx += zip) {
                    if (idx + zip - 1 >= length) {
                        if (perZipCount >= 2) {
                            zipCount += zip + String.valueOf(perZipCount).length();
                        } else {
                            zipCount += zip;
                        }
                        zipCount += length - idx;
                        break;
                    }

                    String currSub = s.substring(idx, idx + zip);
                    if (currSub.equals(sub)) {
                        perZipCount++;
                    } else {
                        if (perZipCount >= 2) {
                            zipCount += zip + String.valueOf(perZipCount).length();
                        } else {
                            zipCount += zip;
                        }
                        sub = currSub;
                        perZipCount = 1;
                    }
                }

                if (zipCount != 0) answer = Math.min(answer, zipCount);
            }
            return answer;
        }
    }
