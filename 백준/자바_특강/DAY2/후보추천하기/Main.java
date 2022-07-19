package 백준.자바_특강.DAY2.후보추천하기;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Student> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int studentNum = Integer.parseInt(st.nextToken());
            boolean isAlreadyExist = false;
            for (Student student : list) {
                if (student.num == studentNum) {
                    student.count++;
                    isAlreadyExist = true;
                    break;
                }
            }

            if (isAlreadyExist == false) {
                if (list.size() == N) {
                    Collections.sort(list);
                    list.remove(N - 1);
                }
                list.add(new Student(studentNum, 1, i));
            }
        }

        Collections.sort(list, Comparator.comparingInt(Student::getNum));

        for (Student student : list) {
            bw.write(student.num + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

class Student implements Comparable<Student> {
    int num;
    int count;
    int date;

    public Student(int num, int count, int date) {
        this.num = num;
        this.count = count;
        this.date = date;
    }

    @Override
    public int compareTo(Student o) {
        if (count > o.count) {
            return -1;
        } else if (count == o.count) {
            return o.date - date;
        } else {
            return 1;
        }
    }

    public int getNum() {
        return num;
    }
}
