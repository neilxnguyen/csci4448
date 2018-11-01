import java.util.ArrayList;
import java.util.List;

public class Customers {
    public static List<Customer> customers;

    public static List<Customer> createDefaultCustomers() {
        Customer customer1 = new Customer(0001);
        Customer customer2 = new Customer(0002);
        Customer customer3 = new Customer(0003);

        customers = new ArrayList<Customer>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        return customers;
    }

    public static Customer login(int id) {
        List<Customer> customers = createDefaultCustomers();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        System.out.println("Customer not found, creating new customer.");
        return null;
    }
}
