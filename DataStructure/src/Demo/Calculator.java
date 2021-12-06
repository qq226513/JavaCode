package Demo;

public class Calculator {
    public static void main(String[] args) {
        stack numStack = new stack(10);
        stack operatorStack = new stack(10);
        String s = "6+3*2";
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int operator = 0;
        char[] expression = s.toCharArray();
        for (int i = 0; i < expression.length; i++) {
            if (operatorStack.isOperator(expression[i])){
                //如果是运算符
                if (operatorStack.isEmpty()){
                    //如果符号栈为空，直接入栈
                    operatorStack.pop(expression[i]);
                }else if (operatorStack.priority(expression[i])
                        //如果符号栈的符号优先级大于当前运算符
                        <= operatorStack.priority(operatorStack.peek())){
                    //则从数栈中pop两个数，符号栈中pop出一个符号
                    num1 = numStack.push();
                    num2 = numStack.push();
                    operator = operatorStack.push();
                    //运算
                    res = numStack.cal(num1,num2,operator);
                    //运算结果入栈
                    numStack.pop(res);
                    //运算符入栈
                    operatorStack.pop(expression[i]);
                }
            }else {
                numStack.pop(expression[i]-48);
            }
        }
        while (!operatorStack.isEmpty()){
            num1 = numStack.push();
            num2 = numStack.push();
            operator = operatorStack.push();
            res = numStack.cal(num1,num2,operator);
            numStack.pop(res);
        }
        System.out.println(numStack.push());


    }
}

class stack {
    int maxSize;
    int[] arr;
    int top = -1;

    public stack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
    }

    public void pop(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        arr[++top] = value;
    }

    public int push() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return arr[top--];
    }

    public int peek(){
        return arr[top];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOperator(int operator) {
        if (operator == '*' || operator == '/' || operator == '+' || operator == '-') {
            return true;
        }
        return false;
    }

    public int cal(int num1, int num2, int operator) {
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
}


