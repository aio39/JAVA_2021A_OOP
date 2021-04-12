package chap15;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push((char) ('A' + i)); // char의 Wrapper class -> character - auto boxing으로 자동 전환됨.
        }
        System.out.println(stack);
        // 다음에 인출될 원소 엿보기.
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        while (stack.size() > 0) {
            Character nextVal = stack.pop();
            System.out.println(nextVal);
        }
        System.out.println(stack);

    }

}
