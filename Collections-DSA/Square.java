import java.util.*;
public class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        int sum = 0;
        while (num != sum) {
            sum += (num%10) * (num%10);
            sum += (num/10) * (num/10);
            count++;
            if (count > Integer.MAX_VALUE) {
                System.out.println(-1);
            }
        }
        System.out.println(count);
    }
}
