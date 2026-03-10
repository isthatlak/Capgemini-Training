import java.util.Stack;

public class JVMCallStackSimulation {

    static Stack<String> callStack = new Stack<>();

    static void printStack() {
        System.out.println("Current Call Stack: " + callStack);
    }

    static void mainMethod() {
        callStack.push("main()");
        printStack();

        login();

        callStack.pop();
        printStack();
    }

    static void login() {
        callStack.push("login()");
        printStack();

        validate();

        callStack.pop();
        printStack();
    }

    static void validate() {
        callStack.push("validate()");
        printStack();

        callStack.pop();
        printStack();
    }

    public static void main(String[] args) {
        mainMethod();
    }
}
