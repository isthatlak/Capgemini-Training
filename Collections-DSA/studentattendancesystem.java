import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class studentattendancesystem {

    static class Student {
        String username;
        String password;
        String name;
        ArrayList<Integer> marks = new ArrayList<>();

        Student(String username, String password, String name) {
            this.username = username;
            this.password = password;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        System.out.println("Simple Student Attendance & Marks System");
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Student> users = new HashMap<>();
        HashSet<String> usernames = new HashSet<>();

        String[] materials = {
            "Introduction_to_Java.pdf",
            "Data_Structures_Basics.pdf",
            "Operating_Systems_Notes.pdf"
        };

        while (true) {
            System.out.println();
            System.out.println("Main Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String opt = scanner.nextLine().trim();

            if (opt.equals("1")) {
                System.out.print("Choose username: ");
                String username = scanner.nextLine().trim();
                if (!usernames.add(username)) {
                    System.out.println("Username already exists.");
                    continue;
                }
                System.out.print("Full name: ");
                String name = scanner.nextLine().trim();
                System.out.print("Password: ");
                String password = scanner.nextLine().trim();
                users.put(username, new Student(username, password, name));
                System.out.println("Registration successful for " + name + " (" + username + ")");

            } else if (opt.equals("2")) {
                System.out.print("Username: ");
                String username = scanner.nextLine().trim();
                System.out.print("Password: ");
                String password = scanner.nextLine().trim();

                Student s = users.get(username);
                if (s == null || !s.password.equals(password)) {
                    System.out.println("Invalid username or password.");
                    continue;
                }

                System.out.println("Welcome, " + s.name + "!");

                boolean logged = true;
                while (logged) {
                    System.out.println();
                    System.out.println("Student Menu:");
                    System.out.println("1. View Study Materials");
                    System.out.println("2. Assign Random Marks (simulate)");
                    System.out.println("3. View Marks and Total");
                    System.out.println("4. Logout");
                    System.out.print("Choose an option: ");
                    String so = scanner.nextLine().trim();

                    if (so.equals("1")) {
                        System.out.println("Available study materials:");
                        for (int i = 0; i < materials.length; i++) {
                            System.out.println((i + 1) + ". " + materials[i]);
                        }
                    } else if (so.equals("2")) {

                        Random rnd = new Random();
                        s.marks.clear();
                        int subjects = 5;
                        System.out.println("Assigning random marks for " + subjects + " subjects...");
                        for (int i = 0; i < subjects; i++) {
                            int mark = rnd.nextInt(101); // 0-100
                            s.marks.add(mark);
                            System.out.println("Subject " + (i + 1) + ": " + mark);
                        }
                        System.out.println("Marks assigned.");
                    } else if (so.equals("3")) {
                        if (s.marks.isEmpty()) {
                            System.out.println("No marks recorded yet. Use option 2 to assign marks.");
                        } else {
                            int total = 0;
                            System.out.println("Marks for " + s.name + ":");
                            for (int i = 0; i < s.marks.size(); i++) {
                                int m = s.marks.get(i);
                                System.out.println("Subject " + (i + 1) + ": " + m);
                                total += m;
                            }
                            System.out.println("Total sum: " + total);
                        }
                    } else if (so.equals("4")) {
                        logged = false;
                        System.out.println("Logged out.");
                    } else {
                        System.out.println("Invalid option.");
                    }
                }

            } else if (opt.equals("3")) {
                System.out.println("Goodbye.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
