package chap15;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackTest {
    public static void main(String[] args) {
        // test1();
        // test2();
        for (String exp : testArr) {

            checkExpression(exp);
        }
    }

    public static final String[] testArr = { "2 * ( 3 + 2 ) / ( 3 + 1 )", "2 * (( 3 + 2 ) / ( 3 + 1 )",
            "2 * ( 3 + 2 ) / ( 3 + 1 ))", "(2 * ( 3 + 2 ) / ( 3 + 1 )" };

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

    private static void test2() {
        String str = "APPLE/ GRAPE/ BANANA/ STRAWBERRY";
        StringTokenizer st = new StringTokenizer(str, "/ ");
        while (st.hasMoreTokens()) {
            System.out.println("[" + st.nextToken() + "]");
        }
    }

    private static void checkExpression(String exp) {
        // System.out.println("수식을 입력해주세요");
        // Scanner input = new Scanner(System.in);
        // String exp = input.nextLine();
        Stack<Character> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(exp, " ");
        while (st.hasMoreTokens()) {
            String nextVal = st.nextToken();
            if (nextVal.equals("(")) {
                stack.push(nextVal.charAt(0));
            } else if (nextVal.equals(")")) {
                if (stack.isEmpty()) {
                    System.out.println("옳바르지 않은 식입니다." + exp);
                    return;
                }
                stack.pop();

            }
        }
        if (stack.isEmpty()) {
            System.out.println("옳바른 식입니다." + exp);
        } else {
            System.out.println("옳바르지 않은 식입니다." + exp);
        }

    }

}
