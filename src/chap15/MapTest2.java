package chap15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MapTest2 {
    public static final Random random = new Random();

    public static void main(String[] args) {
        // intList();
        ObjectList();
    }

    public static void PrintArray(List arr) {
        for (Object a : arr) {
            System.out.println(a.toString());
        }
    }

    private static void ObjectList() {
        ArrayList<Student2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student2("이름" + i, random.nextInt(100) + 1));
        }
        PrintArray(list);
        System.out.println("---------------------------");
        // Collections.sort(list);
        sort(list);
        PrintArray(list);
    }

    private static void intList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100) + 1);
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    private static void sort(List<Student2> list) {
        for (int i = 0; i < list.size(); i++) {
            int min = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(min).getGrade() - list.get(j).getGrade() < 0) {
                    min = j;
                }
            }
            swap(list, min, i);
        }

    }

    private static void swap(List<Student2> list, int i, int j) {
        Student2 tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

}

class Student2 implements Comparable<Student2> {

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    private String name;
    private int grade;

    public Student2(String name, int grade) {
        super();
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student2 [grade=" + grade + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Student2 o) {
        return this.grade - o.grade;
    }

}