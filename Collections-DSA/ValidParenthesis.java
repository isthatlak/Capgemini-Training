import java.util.*;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }

            else if (c == ')') {
                if (st.isEmpty() || st.pop() != '(') return false;
            }
            else if (c == '}') {
                if (st.isEmpty() || st.pop() != '{') return false;
            }
            else if (c == ']') {
                if (st.isEmpty() || st.pop() != '[') return false;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        System.out.println(isValid(s) ? "Valid" : "Invalid");
        sc.close();
    }
}
