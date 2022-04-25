package 백준.자바.단어정렬하기;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].equals(arr[j])) {
                    arr[i] = "";
                } else if (arr[i].length() > arr[j].length()) {
                    if (arr[i] != "" && arr[j] != "") {
                        String tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }

        for (String str : arr) {
            if (str != "")
                bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
