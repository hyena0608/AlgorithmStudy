package 백준.자바_특강.DAY2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    public static void main(String[] args) {

        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(1, 2, 3);
        Item item3 = new Item(1, 1, 2);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        Comparator<Item> comp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.c - o2.c;
            }
        };

        Collections.sort(list, comp);
        System.out.println(list);


        // 아래가 현업 (+ 인터페이스 메서드)
        // b의 오름차순 정렬
        Collections.sort(list, Comparator.comparingInt(Item::getB));
        System.out.println(list);
        // b의 내림차순 정렬
        Collections.sort(list, Comparator.comparingInt(Item::getB).reversed());
        System.out.println(list);
        // 붙여나갈 수 있음
        Collections.sort(list, Comparator.comparingInt(Item::getB).thenComparing(Item::getA));
        System.out.println(list);
        // reversed는 하나 정도만 사용하자. (아니면 헷갈림)
        Collections.sort(list, Comparator.comparingInt(Item::getB).reversed().thenComparing(Item::getA).reversed());
        System.out.println(list);
    }

}

class Item implements Comparable<Item> {
    int a, b, c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public int compareTo(Item o) {
        // b가 앞, o.b가 뒤

        // 음수 -> 원래 순서
        // 0
        // 양수 -> SWAP

        // a기준 내림, b기준 올림

        if (a > o.a) {
            return -1;
        } else if (a == o.a) {
            return b - o.b;

        } else {
            return 1;
        }
//        return b - o.b;

//        return Integer.compare(b, o.b);


    }
}
