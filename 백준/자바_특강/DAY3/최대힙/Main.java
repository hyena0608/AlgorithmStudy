package 백준.자바_특강.DAY3.최대힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(0);

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                System.out.println(remove());
            } else {
                insert(input);
            }
        }

    }

    static void insert(int value) {
        // 리스트 맨 마지막 노드에 데이터를 넣는다.
        list.add(value);

        int current = list.size() - 1;
        int parent = current / 2;

        while (true) {
            if (parent == 0 || list.get(current) <= list.get(parent)) {
                break;
            }

            // 부모 노드와 크기를 비교한다.
            if (list.get(parent) < list.get(current)) {
                // 부모가 더 작을 경우 스왑한다.
                int temp = list.get(parent);
                list.set(parent, list.get(current));
                list.set(current, temp);
            }
            // 현재 노드가 부모 노드 위치가 된다.
            current = parent;
            parent = current / 2;
        }

    }

    static int remove() {
        if (list.size() == 1) {
            // 데이터가 없을 때 종료
            return 0;
        } else {
            // 데이터가 있다.

            // 루트 노드를 가져온다
            int top = list.get(1);
            // 마지막 노드를 루트 노드에 넣는다.
            list.set(1, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int current = 1;
            while (true) {
                int childLeft = current * 2;
                int childRight = current * 2 + 1;

                if (list.size() <= childLeft) {
                    // 왼쪽 자식 노드의 범위가 트리를 뛰어 넘었을 때
                    break;
                }

                int maxValue = list.get(childLeft);
                int maxPos = childLeft;

                if (list.size() > childRight && list.get(childRight) > maxValue) {
                    // 오른쪽 자식 노드의 범위가 트리를 뛰어 넘지 않고 왼쪽 자식의 값보다 클 때
                    maxValue = list.get(childRight);
                    maxPos = childRight;
                }

                // 선택된 자식 노드와 Swap
                if (list.get(current) < maxValue) {
                    int temp = maxValue;
                    list.set(maxPos, list.get(current));
                    list.set(current, temp);
                }
                current = maxPos;
            }
            return top;
        }
    }
}
