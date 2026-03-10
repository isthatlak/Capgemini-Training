import java.util.*;

public class shoppingcart {
    public static void main(String[] args) {
        List<String> cart = new ArrayList<>();
        System.out.println("Add items to your shopping cart.");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add item");
            System.out.println("2. Get item");
            System.out.println("3. Remove item");
            System.out.println("4. Size of cart");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter item to add:");
                    String item = scanner.nextLine();
                    cart.add(item);
                    break;
                case 2:
                    System.out.println("Enter index of item to get:");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < cart.size()) {
                        System.out.println("Item at index " + index + ": " + cart.get(index));
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    System.out.println("Enter item to remove:");
                    String removeItem = scanner.nextLine();
                    if (cart.contains(removeItem)) {
                        cart.remove(removeItem);
                        System.out.println("Item removed.");
                    } else {
                        System.out.println("Item not in cart.");
                    }
                    break;
                case 4:
                    System.out.println("Size of cart: " + cart.size());
                    break;
                case 5:
                    System.out.println("Exiting.");
                default:
                    flag = false;
            }
        }
    }
}