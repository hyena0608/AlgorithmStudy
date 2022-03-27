package 인프런_자바_알고리즘_문제_기초.응급실;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author hyena
 */
public class Main {
    public int solution(int patientsCount, int patientNum, int[] patients) {
        int answer = 0;
        Queue<Person> patientsQueue = new LinkedList<>();

        for (int i = 0; i < patientsCount; i++) {
            patientsQueue.offer(new Person(i, patients[i]));
        }

        while (!patientsQueue.isEmpty()) {
            Person selectedPatient = patientsQueue.poll();
            Boolean isFirstPatient = true;
            for (Person leftPatient : patientsQueue) {
                if (leftPatient.priority > selectedPatient.priority) {
                    patientsQueue.offer(selectedPatient);
                    isFirstPatient = false;
                    break;
                }
            }
            if (isFirstPatient) {
                answer++;
                if (selectedPatient.id == patientNum) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stPatient = new StringTokenizer(br.readLine());
        int patientsCount = Integer.parseInt(stPatient.nextToken());
        int patientNum = Integer.parseInt(stPatient.nextToken());

        StringTokenizer stDanger = new StringTokenizer(br.readLine());
        int[] patients = new int[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            patients[i] = Integer.parseInt(stDanger.nextToken());
        }

        int answer = T.solution(patientsCount, patientNum, patients);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private class Person {
        int id;
        int priority;

        private Person() {
        }

        private Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}

