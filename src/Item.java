public class Item {

    int id , quan , price;
    String name , type , nameItem ,author;

    public Item(int id, int quan, int price, String name, String type, String nameItem, String author) {
        this.id = id;
        this.quan = quan;
        this.price = price;
        this.name = name;
        this.type = type;
        this.nameItem = nameItem;
        this.author = author;
    } // Constructor

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public String getType() {
        return type;
    }

    public String getNameItem() {
        return nameItem;
    }

    public String getAuthor() {
        return author;
    }

    public int getId(){return this.id;}
    public int getQuan(){return this.quan;}
    public int getPrice(){return this.price;}
    public String getName(){return this.name;}
    public void addQuan(int quan){
        this.quan+=quan;
    }
}
