import java.io.Serializable;

public class Product implements Serializable {
    public String id;
    public String name;
    public String description;
    public int stock;
    public double price;
    public double discount; //Discount percentage. An item that is 25% off should have discount = 25

    public Product(String id, String name, double price) {
        setId(id);
        setName(name);
        setPrice(price);
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getStock() {
        return this.stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public double getDiscount() {
        return this.discount;
    }

    public double getDiscountedPrice() {
        return (this.price * (100 - this.discount) / 100);
    }

    public void purchase() {
        if(this.stock == 0) {
            System.out.println("Cannot purchase, no item in stock");
        }
        else {
            this.stock = this.stock - 1;
        }
    }
}
