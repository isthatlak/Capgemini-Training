import java.util.*;

public class MinMaxStack {

    private Stack<Long> stack;
    private long min;
    private long max;

    public MinMaxStack() {
        stack = new Stack<>();
    }

    public void push(long x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = x;
            max = x;
        }
        else if (x < min) {
            stack.push(2 * x - min);
            min = x;
        }
        else if (x > max) {
            stack.push(2 * x - max);
            max = x;
        }
        else {
            stack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        long top = stack.pop();

        if (top < min) {
            min = 2 * min - top;
        }
        else if (top > max) {
            max = 2 * max - top;
        }
    }

    public long getMin() {
        return min;
    }

    public long getMax() {
        return max;
    }

    public long peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        long top = stack.peek();

        if (top < min) return min;
        if (top > max) return max;
        return top;
    }

    public static void main(String[] args) {

        MinMaxStack s = new MinMaxStack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Get Min");
            System.out.println("5. Get Max");
            System.out.println("6. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    long val = sc.nextLong();
                    s.push(val);
                    System.out.println("Pushed " + val);
                    break;

                case 2:
                    s.pop();
                    System.out.println("Popped");
                    break;

                case 3:
                    System.out.println("Top: " + s.peek());
                    break;

                case 4:
                    System.out.println("Min: " + s.getMin());
                    break;

                case 5:
                    System.out.println("Max: " + s.getMax());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}