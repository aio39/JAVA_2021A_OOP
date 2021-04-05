package chap15;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayListTest {
    public static void main(String[] args) {
        // ArrayList<String> list = new ArrayList<>(); list와 linked list 사용법은 거의 동일
        setTest();
    }

    private static void setTest() {
        // 순서 없고, 중복 허용하지 않는다.
        // ! Set<String> set = new HashSet<>(); // 순서 보장 안됨
        // Set<String> set = new LinkedHashSet<>();

        // ! TreeSet은 key와 value 들의 중복을 허용하지는 않지만 값에 따라 정렬한다.
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String[] strArr = { "s", "b", "a", "s", "c" };

        Random ran = new Random(System.currentTimeMillis());

        Set<Integer> set2 = new HashSet<>();
        while (set2.size() < 7) {
            Integer rotto = ran.nextInt(45) + 1;
            if (set2.add(rotto) == false) {
                System.out.println(rotto + " 는 이미 존재하는 값 ");
            }
        }
        System.out.println(set2);
        System.out.println(set);
        // for (int i = 0; i < set.size(); i++) {
        // 순서가 없으므로 set.get() 은 불가능 ?
        // }
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next()); // hasnext를 확인인 없이 접근하면 에러가 남.
        }
        System.out.println();

        iter = set.iterator();
        System.out.println();
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
