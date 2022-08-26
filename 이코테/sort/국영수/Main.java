package 이코테.sort.국영수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Student> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Student(kor, eng, math, name));
        }

        list.sort((o1, o2) -> {
            int compare = 0;
            if (o1.kor == o2.kor) {
                if (o1.eng == o2.eng) {
                    if (o1.math ==  o2.math) {
                        compare = o1.name.compareTo(o2.name);
                    } else {
                        compare = Integer.compare(o1.math, o2.math);
                    }
                } else {
                    compare = Integer.compare(o1.eng, o2.eng);
                }
            } else {
                compare = Integer.compare(o1.kor, o2.kor);
            }

            return compare;
        });

        for (Student student : list) {
            System.out.println(student.name);
        }
    }
}

class Student {
    int kor, eng, math;
    String name;

    public Student(int kor, int eng, int math, String name) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.name = name;
    }
}
