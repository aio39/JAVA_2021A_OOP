package chap15;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();

        for (int i = 1; i < 100; i++) {
            list1.add(i);

        }
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + "");

        }

        // MyArrayList<Student> list2 = new MyArrayList<>();
        // for (int i = 0; i < 20; i++) {
        // list2.add(new Student(1 + "", (i + 1) * 10));

        // }
        // for (int i = 0; i < 20; i++) {
        // System.out.println(list2.get(i));

        // }
    }

}
