import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    public int id;
    public String email;
    public String phone;
    public int userType; //0 for customer, 1 for admin
    public String firstName;
    public String lastName;
    public ArrayList<Product> shoppingCart = new ArrayList<>();


    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void addShoppingCart(Product product) {
        //CODE TO ADD ITEM TO SHOPPING CART
        shoppingCart.add(product);
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getId() {
        return Integer.toString(id);
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setPhone(String phoneNumber) {
        this.phone = phoneNumber;
    }
    public String getPhone() {
        return phone;
    }

    public void setUserType(int type) {
        this.userType = type;
    }
    public int getUserType() {
        return userType;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }
    public String getLastName() {
        return lastName;
    }



    public User(int id, int userType, String phone) {
        this.setId(id);
        this.setUserType(userType);
        this.setPhone(phone);
    }

    public Momento saveCartToMomento() {
        ArrayList<Product> newCart = new ArrayList<>(shoppingCart);
        Momento m = new Momento(newCart);
        return m;
    }

    public void getSavedCartFromMomento(Momento momento) {
        this.shoppingCart = momento.getSavedCart();
    }


}
