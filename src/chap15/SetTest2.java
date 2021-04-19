package chap15;

import java.util.*;

public class SetTest2 {

    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test2() {
        Queue<Integer> queue = new PriorityQueueTest<>(new MyComparator()); // comparator를 넣어주면 poll 이외에도 항상 정렬됨.
        for (int i = 10; i > 0; i--)
            queue.offer(i);
        System.out.println(queue);
        for (Integer n : queue)
            System.out.println(n + "");

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + "번쨰 원소" + queue.poll());
        }

    }

    private static void test1() {
        /*
         * 합집합: retainAll() 차집합: removeAll() 교집합: retainAll()
         */
        /*
         * set1: {1,3,4,5,7,9,10} set2:{2,4,10} set1 U set2 : {1,2,3,4,5,7,9,10} set
         * intersection set2 : {4,10}, set1 -set2 : {1,3,5,7,9}
         */

        Integer[] arr1 = { 1, 3, 4, 5, 6, 7, 9, 10 };
        Integer[] arr2 = { 2, 4, 10 };
        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        // set1.addAll(set2); // mutable
        // System.out.println(set1);

        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println(unionSet);

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println(intersectionSet);

        Set<Integer> diffSet = new HashSet<>(set1);
        diffSet.removeAll(set2);
        System.out.println(diffSet);

        boolean flag = set1.containsAll(set2);
        if (flag) {
            System.out.printf("집합 %s는 집합 %s의 원소를 포함합니다", set1, set2);
        } else {

            System.out.printf("집합 %s는 집합 %s의 원소를 포함하지 않습니다.", set1, set2);
        }

    }

}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return (o1.intValue() - o2.intValue()) * -1;
    }

}