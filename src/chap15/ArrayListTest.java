package chap15;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayListTest {
    public static void main(String[] args) {
        // ArrayList<String> list = new ArrayList<>(); list와 linked list 사용법은 거의 동일
        timeCheckArrayVSLinked();
    }

    private static void extracted() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Milk");
        list.add("Milk2");
        list.add("Milk3");
        list.add(1, "Milk4");
        list.set(2, "Milk5"); // 갱신
        list.remove(3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String s : list) // advanced for loop
            System.out.println(s);

        // list에서 iterator를 반환받는다.
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println("----------");
            System.out.println(iter.next());
        }
    }

    private static void timeCheckArrayVSLinked() {

        List<Integer> list = new ArrayList<>(); // 산입 14ms , 탐색 1ms
        // List<Integer> list = new LinkedList<>(); // 산입 7ms , 탐색 47mm
        IntStream.rangeClosed(1, 10000).forEach(i -> list.add(i));
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            // list.add(100, (i + 1) * 1000);
            list.get(i);

        }
        long endTime = System.currentTimeMillis();

        System.out.print("elapsed Time:" + (endTime - startTime));
    }
}
