import java.util.Stack;

public class CelebrityProblem {

    public static int findCelebrity(int[][] M, int n) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (M[a][b] == 1) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[][] M = {
            {0, 1, 1},
            {0, 0, 1},
            {0, 0, 0}
        };

        int n = M.length;

        int celeb = findCelebrity(M, n);

        if (celeb == -1) {
            System.out.println("No Celebrity");
        } else {
            System.out.println("Celebrity is person: " + celeb);
        }
    }
}