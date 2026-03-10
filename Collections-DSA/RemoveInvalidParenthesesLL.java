import java.util.LinkedList;

public class RemoveInvalidParenthesesLL {

    public static String removeInvalid(String s) {

        LinkedList<Integer> stack = new LinkedList<>();
        boolean[] remove = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.addLast(i);
            }
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    remove[i] = true;
                } else {
                    stack.removeLast();
                }
            }
        }

        while (!stack.isEmpty()) {
            remove[stack.removeLast()] = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "a)b(c)d";
        System.out.println(removeInvalid(s));
    }
}
