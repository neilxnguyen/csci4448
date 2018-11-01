import java.util.ArrayList;
import java.util.List;

public class Admins {
    public static List<Admin> admins;

    public static List<Admin> createDefaultAdmins() {
        Admin admin1 = new Admin(0000);
        Admin admin2 = new Admin(-1);
        Admin admin3 = new Admin(9999);

        admins = new ArrayList<Admin>();
        admins.add(admin1);
        admins.add(admin2);
        admins.add(admin3);

        return admins;
    }


    public static Admin login(int id) {
        List<Admin> admins = createDefaultAdmins();
        for (Admin admin : admins) {
            if (admin.getId() == id) {
                return admin;
            }
        }
        System.out.println("Wrong ID");
        return null;
    }
}
