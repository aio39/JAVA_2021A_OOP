package chap15;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest2 {
    public static void main(String[] args) {
        test1();
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
    }

}
