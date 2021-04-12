package chap15;

import java.util.*;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= 10; i++) {
            dq.add(i); // push 가능 // addFirst //add last
        }
        while (dq.size() > 0) {
            Integer val = dq.poll(); // pollFirst
            System.out.print(val + " ");
        }

        for (int i = 1; i <= 10; i++) {
            dq.add(i);
        }
        while (dq.size() > 0) {
            Integer val = dq.pollLast(); // LiPO
            System.out.print(val + " ");
        }
    }

}
