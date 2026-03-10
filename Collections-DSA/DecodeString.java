import java.util.*;

public class DecodeString {

    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            }

            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prev.append(curr);
                }
                curr = prev;
            }

            else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
    public static void main(String[] args) {

        String s1 = "3[a2[b]]";
        String s2 = "2[ab3[c]]";
        String s3 = "10[a]";

        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
        System.out.println(decodeString(s3));
    }
}
