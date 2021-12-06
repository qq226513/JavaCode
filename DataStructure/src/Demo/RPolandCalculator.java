package Demo;

import java.util.Stack;

public class RPolandCalculator {
    public static void main(String[] args) {
        String expression = "123+4*+5-";
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int temp = 0;
        Stack<Integer> numStack = new Stack<>();
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isOperator(chars[i])) {
                num1 = numStack.pop();
                num2 = numStack.pop();
                res = cal(num1, num2, chars[i]);
                numStack.push(res);
            } else {
                temp = chars[i] - 48;
                numStack.push(temp);
            }
        }
        System.out.println(res);
    }

    public static boolean isOperator(int operator) {
        if (operator == '+' || operator == '*' || operator == '-' || operator == '/') {
            return true;
        }
        return false;
    }

    public static int cal(int num1, int num2, int operator) {
        int res = 0;
        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }


    public static int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }
}
