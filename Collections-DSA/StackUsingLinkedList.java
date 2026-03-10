public class StackUsingLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            System.out.println("Stack is empty");
            return -1;
        }

        int val = head.data;
        head = head.next;
        return val;
    }

    public int peek() {
        if (head == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

    public void display() {
        if (head == null) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack (top to bottom): ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList s = new StackUsingLinkedList();
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();

        System.out.println("Popped: " + s.pop());
        s.display();

        System.out.println("Top: " + s.peek());
    }
}
