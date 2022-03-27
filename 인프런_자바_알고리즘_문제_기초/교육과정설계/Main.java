package 인프런_자바_알고리즘_문제_기초.교육과정설계;

import java.io.*;

/**
 * @author hyena
 */
public class Main {
    public String solution(String primarySubjects, String subjects) {
        String answer = "YES";
        int subjectOrder = -1;
        for (char primarySubject : primarySubjects.toCharArray()) {
            if (subjectOrder < subjects.indexOf(primarySubject)) {
                subjectOrder = subjects.indexOf(primarySubject);
            } else {
                answer = "NO";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String primarySubjects = br.readLine();
        String subjects = br.readLine();

        String answer = T.solution(primarySubjects, subjects);
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
