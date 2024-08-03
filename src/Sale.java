public class Sale {

    int idCustomer , idItem, quan;
    String nameItem;


    public Sale(int idCustomer, int idItem, int quan, String nameItem) {
        this.idCustomer = idCustomer;
        this.idItem = idItem;
        this.quan = quan;
        this.nameItem = nameItem;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdItem() {
        return idItem;
    }

    public int getQuan() {
        return quan;
    }

    public String getNameItem() {
        return nameItem;
    }
}
