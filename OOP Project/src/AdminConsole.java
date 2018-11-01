import java.util.Scanner;

public class AdminConsole {
    public static void AdminConsole() {
        System.out.println("What is your ID?");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();

        Admin a = Admins.login(id);
        if (a != null) {
            System.out.println("You are logged in as an admin");
            System.out.println("Welcome Admin");

        }


    }
}
