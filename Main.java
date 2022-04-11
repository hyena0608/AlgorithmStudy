import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<>();

        for (int a : array) {
            list.add(a);
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
        int cnt = 0;
        for (int[] command : commands) {
            List<Integer> cutList = list.subList(command[0] - 1, command[1]);
            System.out.println("리스트 아래");
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
            System.out.println("컷리스트 아래");
            for (Integer integer : cutList) {
                System.out.print(integer + " ");
            }
            System.out.println();

            Collections.sort(cutList);
            answer[cnt++] = cutList.get(command[2] - 1);
        }

        System.out.println();
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
