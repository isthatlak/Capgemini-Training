import java.util.Stack;

public class ExpressionEngine {

    static Stack<Integer> undoStack = new Stack<>();
    static boolean isValid(String exp) {
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    static String infixToPostfix(String exp) {

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                    postfix.append(exp.charAt(i++));
                }
                postfix.append(' ');
                i--;
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop();
            }

            else {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString();
    }

    static int evaluatePostfix(String postfix) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < postfix.length() && Character.isDigit(postfix.charAt(i))) {
                    num = num * 10 + (postfix.charAt(i++) - '0');
                }
                stack.push(num);
            }

            else if (ch == ' ') continue;

            else {
                int b = stack.pop();
                int a = stack.pop();

                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        return stack.pop();
    }

    static int evaluate(String exp) {

        if (!isValid(exp)) {
            throw new RuntimeException("Invalid Expression");
        }

        String postfix = infixToPostfix(exp);
        int result = evaluatePostfix(postfix);

        undoStack.push(result);
        return result;
    }

    static Integer undo() {
        if (undoStack.isEmpty()) return null;
        undoStack.pop();
        return undoStack.isEmpty() ? null : undoStack.peek();
    }

    public static void main(String[] args) {

        String exp = "(10+5)*2";

        int result = evaluate(exp);
        System.out.println("Result: " + result);

        Integer undoResult = undo();
        System.out.println("After UNDO: " + undoResult);
    }
}
