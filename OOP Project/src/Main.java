import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Are you a Customer or Admin?");
        Scanner input = new Scanner(System.in);
        String user = input.nextLine();

        if (user.equals("Admin") || user.equals("admin")) {
            System.out.println("You are an Admin");
            AdminConsole.AdminConsole();
        }
        if (user.equals("Customer") || user.equals("customer")) {
            System.out.println("You are a Customer");
            CustomerConsole.customerConsole();
        }
    }


}
