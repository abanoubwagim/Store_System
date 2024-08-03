public class Customer {

    private int id , cart;
    private String name ;


    public Customer(int id, int cart, String name) {
        this.id = id;
        this.cart = cart;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }
}
