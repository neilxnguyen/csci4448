import java.util.Scanner;

public class CustomerConsole {
    public static void customerConsole(){
        System.out.println("What is your ID?");

        Scanner input = new Scanner(System.in);
        int id = input.nextInt();

        Customer c = Customers.login(id);
        if (c == null) {
            System.out.println("You are not registered. Registering new Customer...");
        }
        if (c != null) {
            System.out.println("You are logged in as a Customer");
            System.out.println("Welcome Customer");
        }
    }
}
