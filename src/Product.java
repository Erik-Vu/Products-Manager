/**
 * Class chua thong tin san pham
 * Phuong thuc khoi tao, getter, setter
 */
public class Product {
    private String id;
    private String title;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String id, String title, int quantity, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*
    Phuong thuc sau ky tu thanh String de in vao data.txt
     */
    @Override
    public String toString() {
        return id + "," + title + "," + quantity
                + "," + price;
    }

    /*
    Phuong thuc sau ky tu thanh String de in vao console_output.txt
     */
    public String writeString() {
        return "| " + id + "   |" + title + "   |" + quantity
                + "   | " + price + "   |";
    }
}
