package chap15;

import java.util.*;

public class PriorityQueueTest {

    public static void main(String[] args) {
        // test1();
        test2();

    }

    private static void test1() {
        Queue<Integer> q = new PriorityQueue<>();
        // random ten int between 1~100
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(100) + 1;
            q.offer(val);
        }
        // 큐의 내용 확인
        System.out.println(q);

        // 큐의 element를 하나씩 pull 해보자.

        while (!q.isEmpty()) {
            System.out.println(q.poll());

        }
    }

    private static void test2() {
        // 우선 순위 큐에 들어갈 원소를 정렬하는 방법은 2가지가 있다.
        // 1. 그 원소의 class comparable interface를 구현
        // 2. 우선 순위 큐에게 그 원소를 비교 하는 방법을 따로 알려주는 것 -> Comparator
        // 1,2 방법이 전부 구현된 상태라면 2번이 우선된다.
        TaskComparator comp = new TaskComparator();
        // Queue<Task> q = new PriorityQueue<>(comp);

        // Queue<Task> q = new PriorityQueue<>(new Comparator<Task>() {
        // @Override
        // public int compare(Task o1, Task o2) {
        // return -1 * (o1.priority - o2.priority);
        // }
        // });

        // 람다 - 오직 하나의 추상 메소드만을 가지는 인터페이스의 구현
        Queue<Task> q = new PriorityQueue<>((o1, o2) -> o2.priority = o1.priority);

        q.add(new Task(5, "작업1"));
        q.add(new Task(3, "작업2"));
        q.add(new Task(6, "작업3"));
        q.add(new Task(2, "작업4"));
        q.add(new Task(3, "작업5"));

        while (!q.isEmpty()) {
            Task task = q.poll();
            System.out.println(task);

        }
    }

}

class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return o1.desc.compareTo(o2.desc);
        // return o2.priority - o1.priority;

    }

}

class Task implements Comparable<Task> {
    int priority;
    String desc;

    public Task(int priority, String desc) {
        this.priority = priority;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "[priority:" + priority + ", desc:" + desc + "]";
    }

    @Override
    public int compareTo(Task o) {
        if (this.priority == o.priority)
            return 1;
        return this.priority - o.priority;
    }
}