import java.util.*;

public class dms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Map<String, String>> orders = new HashMap<>();
        int orderIdCounter = 1000;
        String[] deliveryDriver = {"Raghav", "Ravi", "Priya", "Ankit", "Sneha"};
        boolean flag = true;
        while(flag){
            System.out.println("\nDelivery Management System");
            System.out.println("1. Place Order");
            System.out.println("2. Track Order");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    Map<String, String> orderDetails = new HashMap<>();
                    System.out.print("\nEnter Owner Name: ");
                    orderDetails.put("Owner Name", sc.nextLine());
                    System.out.print("\nEnter Product: ");
                    orderDetails.put("Product", sc.nextLine());
                    System.out.print("\nEnter Address: ");
                    orderDetails.put("Address", sc.nextLine());
                    System.out.print("\nEnter Contact Number: ");
                    orderDetails.put("Contact Number", sc.nextLine());
                    System.out.print("\nEnter Quantity: ");
                    orderDetails.put("Quantity", sc.nextLine());
                    System.out.print("\nEnter Price: ");
                    orderDetails.put("Price", sc.nextLine());
                    System.out.print("\nEnter Date: ");
                    orderDetails.put("Date", sc.nextLine());
                    orderDetails.put("\nStatus", "Assigned");
                    orders.put(orderIdCounter, orderDetails);
                    String assignedDriver = deliveryDriver[new Random().nextInt(deliveryDriver.length)];
                    orderDetails.put("Delivery Driver", assignedDriver);
                    System.out.println("Order placed successfully! Your Order ID is: " + orderIdCounter);
                    int randomContact = new Random().nextInt(1000000000);
                    orderDetails.put("Driver Contact", String.valueOf(randomContact));
                    orderIdCounter++;
                    break;
                case 2:
                    System.out.print("\nEnter Order ID to track: ");
                    int orderId = sc.nextInt();
                    sc.nextLine(); 
                    if(orders.containsKey(orderId)){
                        Map<String, String> details = orders.get(orderId);
                        System.out.println("\nOrder Details:");
                        for(Map.Entry<String, String> entry : details.entrySet()){
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    } else {
                        System.out.println("\nOrder ID not found.");
                    }
                    break;
                case 3:
                    flag = false;
                    System.out.println("\nExiting Delivery Management System. Thank you for using our services!\n");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
        sc.close();
    }
}