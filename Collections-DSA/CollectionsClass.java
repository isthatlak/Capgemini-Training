import java.util.*;
public class CollectionsClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();

        System.out.print("How many items? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter item " + i + ": ");
            arr.add(sc.nextLine());
        }

        System.out.println(arr);

        System.out.print("Enter index to update: ");
        int ui = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new value: ");
        arr.set(ui, sc.nextLine());
        System.out.println(arr);

        System.out.print("Enter index to remove: ");
        int ri = sc.nextInt();
        arr.remove(ri);
        System.out.println(arr);

        sc.close();
    }
}
