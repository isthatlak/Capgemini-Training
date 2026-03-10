import java.util.Scanner;

class ATMmachine {
    private int bal = 0;
    private int PIN;
    Scanner sc = new Scanner(System.in);

    ATMmachine(int pin) {
        this.PIN = pin;
    }

    public void checkBalance(int pinCheck) {
        if (PIN == pinCheck) {
            System.out.println("The balance is = " + bal);
        } else {
            System.out.println("Invalid PIN, try again.");
        }
    }

    public void deposit(int pinCheck, int amount) {
        if (PIN == pinCheck) {
            bal += amount;
            System.out.println("New Balance is: " + bal);
        } else {
            System.out.println("Invalid PIN.");
        }
    }

    public void withdraw(int pinCheck, int amount) {
        if (PIN == pinCheck) {
            if (amount <= bal) {
                bal -= amount;
                System.out.println("New Balance is: " + bal);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid PIN.");
        }
    }

    public void changePin(int pinCheck) {
        if (PIN == pinCheck) {
            System.out.print("Enter the new PIN: ");
            int newPIN = sc.nextInt();
            PIN = newPIN;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid PIN.");
        }
    }

    public void quickWithdrawal(int pinCheck) {
        if (PIN == pinCheck) {
            System.out.println("Select the amount to quick withdraw:");
            System.out.println("1. 100\n2. 500\n3. 1000\n4. 5000");

            int select = sc.nextInt();
            int amount = 0;

            switch (select) {
                case 1: amount = 100; break;
                case 2: amount = 500; break;
                case 3: amount = 1000; break;
                case 4: amount = 5000; break;
                default:
                    System.out.println("Invalid option.");
                    return;
            }

            if (amount <= bal) {
                bal -= amount;
                System.out.println("New Balance is: " + bal);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid PIN.");
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Set your PIN: ");
        int pin = sc.nextInt();

        ATMmachine account = new ATMmachine(pin);
        boolean flag = true;

        while (flag) {
            System.out.println("\nSelect the function:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Change PIN");
            System.out.println("5. Quick Withdrawal");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            System.out.print("Enter PIN: ");
            int pinCheck = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    int amount1 = sc.nextInt();
                    account.withdraw(pinCheck, amount1);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    int amount2 = sc.nextInt();
                    account.deposit(pinCheck, amount2);
                    break;

                case 3:
                    account.checkBalance(pinCheck);
                    break;

                case 4:
                    account.changePin(pinCheck);
                    break;

                case 5:
                    account.quickWithdrawal(pinCheck);
                    break;

                case 6:
                    flag = false;
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}