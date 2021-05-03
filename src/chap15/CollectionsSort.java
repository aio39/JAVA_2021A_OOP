package chap15;

import java.util.*;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {

    public static void main(String[] args) {
        // sortTest();
        // shuffleTest();
        binarySearch();
    }

    public static void binarySearch() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        int idx = Collections.binarySearch(list, 5);
        if (idx > 0) {
            System.out.println(idx);

        } else {
            System.out.println("없습니다5");
        }
    }

    public static void shuffleTest() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println("After shuffle");
        Collections.shuffle(list);
        System.out.println(list);
    }

    public static void sortTest() {
        String[] sample = { "d", "i", "walk", "I", "the", "line", "9" };

        List<String> list = Arrays.asList(sample);
        Collections.sort(list);
        Collections.sort(list, (o1, o2) -> o1.compareToIgnoreCase(o2));
        for (String s : list)
            System.out.println(s);
    }

}
