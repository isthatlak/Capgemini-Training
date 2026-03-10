import java.util.LinkedList;
import java.util.Queue;

public class StackCostlyPush {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {

        q2.offer(x);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int peek() {
        return q1.peek();
    }
    public static void main(String[] args) {
        StackCostlyPush s = new StackCostlyPush();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
