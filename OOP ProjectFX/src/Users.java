import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Users {
    public static List<User> users;
    public static void initializeUsers() throws ClassNotFoundException, IOException{
        users = new ArrayList<>();
        boolean fileExists = new File("users.tmp").isFile();
        if(fileExists) {
            System.out.println("Users file found, loading into memory...");
            Users.read();
        }
        else {
            System.out.println("Users file not found, rebuilding...");
            Users.createDefaultAdmins();
            Users.createDefaultCustomers();
            Users.save();
            System.out.println("Default Admins and Customers created and saved.");
        }
    }


    public static List<User> admins;

    public static void createDefaultAdmins() {
        User admin1 = new User(0,1,"9999999999");
        User admin2 = new User(-1,1,"0000000000");
        User admin3 = new User(-2,1,"0");

        admins = new ArrayList<User>();
        admins.add(admin1);
        admins.add(admin2);
        admins.add(admin3);
        users = new ArrayList<User>();
        users.add(admin1);
        users.add(admin2);
        users.add(admin3);


    }

    public static List<User> customers;

    public static void createDefaultCustomers() {
        User customer1 = new User(1,0,"2153624786");
        User customer2 = new User(2,0,"2157679916");
        User customer3 = new User(3,0,"3038081337");

        customers = new ArrayList<User>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        users.add(customer1);
        users.add(customer2);
        users.add(customer3);

    }

    public static void save() throws IOException {
        FileOutputStream fos = new FileOutputStream("users.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
    }

    public static void read() throws ClassNotFoundException, FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("users.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        users = (List<User>) ois.readObject();
        ois.close();
    }


    public static User loginID(String id) {
        for (User user : users) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;

    }

    public static User loginNumber(String number) {
        for (User user : users) {
            if(user.getPhone().equals(number)) {
                System.out.println("Found");
                return user;
            }
        }
        return null;
    }

    public static void removeUser(String inputID) {
        for (User user : users) {
            if (user.getId().equals(inputID)) {
                System.out.println("User " + user + " removed");
                users.remove(user);
                break;
            }
        }
    }

}
