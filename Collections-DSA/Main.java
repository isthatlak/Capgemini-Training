import java.util.HashSet;
import java.util.Scanner;

class Main{
    static HashSet<Ticket> allTickets = new HashSet<>();
    static class Ticket{
        long tktId;
        String name;
        String description;
        String assignedTo="";
        int priority;
        String status;
    }

    static class TicketingSystem{
        boolean isRunning = true;
        static int counter = 1;
        TicketingSystem(){
            Menu1();
        }

        private void Menu1() {

            while(isRunning) {
                System.out.println("You are logging in as ? ");
                System.out.println("(1) User");
                System.out.println("(2) Admin");
                System.out.println("(3) Quit");

                Scanner sc = new Scanner(System.in);
                int option = sc.nextInt();
                if (option == 1) {
                    UserMenu();
                } else if (option == 2) {
                    AdminMenu();
                }
                else
                    isRunning = false;
            }

        }

        private void AdminMenu() {
            System.out.println("Admin menu");
            System.out.println("(1) Ongoing ticket");
            System.out.println("(2) Check ticket status");
            System.out.println("(3) Set Priority & Assign ticket");
            System.out.println("(4) Go back");

            System.out.println("Enter an option to continue");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch(option){
                case 1:{
                    ShowOngoingTickets();
                    System.out.println("New ticket added!");
                    AdminMenu();
                }
                break;
                case 2:{
                    ShowAllTicketStatus();
                    AdminMenu();

                }
                break;
                case 3:{
                    SetPriorityAndAssign();
                    AdminMenu();

                }
                break;
                case 4:{
                    Menu1();
                }
                default:{
                    System.out.println("Invalid option !");
                    AdminMenu();

                }
            }
        }

        private void SetPriorityAndAssign() {
            System.out.println("Enter ticket id for setting priority");
            Scanner sc = new Scanner(System.in);
            long ticketNum = sc.nextLong();


            for(Ticket x:allTickets){
                if(x.tktId == ticketNum){
                    System.out.println("Enter  priority for this ticket");
                    x.priority = sc.nextInt();
                    System.out.println("Enter  agent name:");
                    Scanner sc2 = new Scanner(System.in);
                    x.assignedTo = sc2.nextLine();
                    x.status = "Agent assigned";
                    System.out.println("Agent assigned and priority set");
                }
            }

            AdminMenu();

        }

        private void ShowAllTicketStatus() {
            System.out.println("Tickets ID    TicketName    Status      Assigned to");
            for(Ticket x:allTickets){
                System.out.println(x.tktId+"     "+x.name+"          "+x.status+"       "+x.assignedTo);
            }
            System.out.println("-----------------------------");
            AdminMenu();
        }

        private void ShowOngoingTickets() {
            System.out.println("Tickets ID    TicketName");
            for(Ticket x:allTickets){
                System.out.println(x.tktId+"                "+x.name);
            }
            System.out.println("-----------------------------");
            AdminMenu();
        }

        private void UserMenu() {
            System.out.println("User menu");
            System.out.println("(1) Raise new ticket");
            System.out.println("(2) Check pending ticket status");
            System.out.println("(3) Go back");
            System.out.println("Enter an option to continue");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch(option){
                case 1:{
                    NewTicket();
                    System.out.println("New ticket added!");
                    UserMenu();
                }
                break;
                case 2:{
                    CheckTicketStatusUser();
                    UserMenu();

                }
                break;
                case 3:{
                    Menu1();

                }
                break;
                default:{
                    System.out.println("Invalid option !");
                    UserMenu();

                }
            }
            System.out.println("-----------------------------");



        }

        private void CheckTicketStatusUser() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter ticket number :");
            long ticketNum = sc.nextLong();
            for(Ticket x: allTickets){
                if(x.tktId == ticketNum){
                    System.out.println("Status : "+x.status);
                    break;

                }
            }
            System.out.println("-----------------------------");
            
            UserMenu();
        }

        private void NewTicket() {
            Ticket tkt = new Ticket();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter name:");
            String name = sc.nextLine();
            System.out.print("Enter description");
            String description = sc.nextLine();

            tkt.tktId = counter++;


            tkt.name = name;


            tkt.description = description;
            tkt.status = "Ticket Created";
            allTickets.add(tkt);
            System.out.println("Ticket created with ID :#" + tkt.tktId);
            System.out.println("-------------------------------------");

            UserMenu();
        }
    }
    public static void main(String[] args){
        TicketingSystem tktSys = new TicketingSystem();
    }

}