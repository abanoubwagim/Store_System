import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static Item [] items = new Item[20]; // initialize an array called (items)
    public static int size = 0; // size of items array
    public static int [] cart = new int[10]; // initialize array called (cart)
    public static Customer [] customers = new Customer[20]; // initialize an array called (customers)
    public static int sizeCus = 0; // size of customers array
    public static Sale [] sales = new Sale[20]; // initialize an array called (sales)
    public static int sizeSal = 0; // size of sales array
    public static void main(String[] args) {
        for (int i = 0 ;i< cart.length ;i++) // initialize -1 to all array
        {
            cart[i] = -1 ;
        }

        mainMenu(); // called mainMenu() method
    }
    public static void mainMenu() {
        while (true) { // It makes loop when the user stops it.
            String menu = "Store System Menu\n" +
                    "1. Add a new Item to Store\n" +
                    "2. Add a new Customer to Store\n" +
                    "3. Add an item to Customer shopping cart\n" +
                    "4. Remove an item from Customer shopping cart\n" +
                    "5. View the items in Customer shopping cart\n" +
                    "6. End shopping and go to checkout\n" +
                    "7. Empty Customer shopping cart\n" +
                    "8. Exit the program\n";
            String number = JOptionPane.showInputDialog(null, menu); // It takes input from the user
            int ch = Integer.parseInt(number); // convert input from user to integer
            switch (ch) {
                case 1:
                    addItem(); // call addItem() method
                    break;
                case 2:
                    addCustomer(); // call addCustomer() method
                    break;
                case 3:
                    addItemToCustomerShoppingCart(); // call addItemToCustomerShoppingCart() method
                    break;
                case 4:
                    String id = JOptionPane.showInputDialog(null,"Enter Customer number : ");
                    int iD = Integer.parseInt(id);
                    removeAnItemFromCustomerShopping(iD); // call removeAnItemFromCustomerShopping() method
                    break;
                case 5:
                    String idc = JOptionPane.showInputDialog(null,"Enter Customer number : ");
                    int idC = Integer.parseInt(idc);
                    display(idC); // call display() method
                    break;
                case 6:
                    String iDc = JOptionPane.showInputDialog(null,"Enter Customer number : ");
                    int iDC = Integer.parseInt(iDc);
                    endShoppingAndGoToCheckout(iDC); // call endShoppingAndGoToCheckout() method
                    break;
                case 7:
                    String IDc = JOptionPane.showInputDialog(null,"Enter Customer number : ");
                    int IDC = Integer.parseInt(IDc);
                    emptyCustomerShoppingCart(IDC); // call emptyCustomerShoppingCart() method
                    break;
                case 8:
                    System.exit(0); // Exit from the program
                    break;
                default:
                    break;
            }
        }
    }
    public static void addItem()
    {   int qu = -1;
        do {
            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField quan = new JTextField();
            JTextField price = new JTextField();
            JTextField type = new JTextField();
            JTextField nameType = new JTextField();
            JTextField Author = new JTextField();

            Object[] message = {
                    "Enter Item Number ", id,
                    "Enter Name Item ", name,
                    "Enter Quan Item ", quan,
                    "Enter Price Item ", price,
                    "Enter Type of Item (B) Book , (S) Shoes , (G) Game", type
            };

            int yesOrNo = JOptionPane.showConfirmDialog(null, message);

            Object[] book = {
                    "Enter Book title ", nameType,
                    "Enter book Author ", Author
            };

            Object[] shoes = {
                    "Enter game number  ", nameType,
                    "Enter place of manufacture  ", Author
            };

            Object[] game = {
                    "Enter item number ", nameType,
                    "Enter place of manufacture ", Author
            };
            int result1 = 1;

            if (type.getText().toUpperCase().equals("B")) {
                result1 = JOptionPane.showConfirmDialog(null, book);
            }

            if (type.getText().toUpperCase().equals("S")) {
                result1 = JOptionPane.showConfirmDialog(null, shoes);
            }

            if (type.getText().toUpperCase().equals("G")) {
                result1 = JOptionPane.showConfirmDialog(null, game);
            }

            if (yesOrNo == JOptionPane.YES_OPTION && result1 == JOptionPane.YES_OPTION) // yes = 0
            {
                int Id = Integer.parseInt(id.getText());
                String Type = type.getText();
                String NameType = nameType.getText();
                String author = Author.getText();
                String Name = name.getText();
                int Quan = Integer.parseInt(quan.getText());
                int Price = Integer.parseInt(price.getText());

                int index = searchIdItem(Id);
                int indexName = searchNameItem(Name);

                if (indexName != -1) {
                    items[indexName].addQuan(Quan);
                    JOptionPane.showMessageDialog(null, "The item exists before , It will be add new item to old item ");
                    return;
                }

                if (index == -1) {
                    items[size] = new Item(Id, Quan, Price, Name, Type, NameType, author);
                    size++;
                    JOptionPane.showMessageDialog(null, "The item has been Created ");
                } else {
                    JOptionPane.showMessageDialog(null, "The number exists before");
                }

            }
            String re = JOptionPane.showInputDialog(null,"Do you want add another item (1/0)");
            qu = Integer.parseInt(re);
        }   while (qu == 1);

        }
    public static void addCustomer(){

        int nu = -1;
        do {

            JTextField id = new JTextField();
            JTextField name = new JTextField();

            Object [] message ={
               "Enter customer number:\n" , id,
               "Enter customer name:\n" , name
               };

            int yes = JOptionPane.showConfirmDialog(null,message);

            if (yes == JOptionPane.YES_OPTION ) // 1
            {
                int Id = Integer.parseInt(id.getText());
                int index = searchCart(Id);

                if (searchIdCus(Id) != -1 )
                {
                    JOptionPane.showMessageDialog(null,"The Customer registered before");
                    return;
                }

                if (index != -1 )
                {
                    customers[sizeCus] = new Customer(Id,index+1,name.getText());
                    sizeCus++;
                    JOptionPane.showMessageDialog(null, "The Customer has been added ");
                }else
                {
                    JOptionPane.showMessageDialog(null,"There are not any empty cart");
                }
            }
            String su = JOptionPane.showInputDialog(null,"Do you want add another item (1/0)");
            nu = Integer.parseInt(su);
        }   while(nu == 1);
    }

    public static void addItemToCustomerShoppingCart()
    {
        int su = -1;
        do {
            String idCus = JOptionPane.showInputDialog(null,"Enter Customer Number : ");
            int idCust = Integer.parseInt(idCus);
            int index = searchIdCus(idCust);
            if (index != -1)
            {
                int no = addItemCart(index);
                if (no == 0)
                {
                return;
                }
            }else
            {
                JOptionPane.showMessageDialog(null,"The Customer doesn't exist");
            }

            String number =JOptionPane.showInputDialog(null,"Do you want try again (1/0) : ");
             su = Integer.parseInt(number);
        }while (su == 1);
    }
    public static int searchCart(int id)
    {
        for (int i = 0 ; i<cart.length;i++)
        {
            if (cart[i] == -1)
            {
                cart[i] = id;
                return i ;
            }
        }
        return -1 ;
    }
    public static int searchIdItem(int id)
    {
        for (int i = 0 ;i< size ;i++)
        {
            if (id == items[i].getId())
            {
                return i;
            }
        }
        return -1;
    }
    public static int searchNameItem(String name)
    {
        for(int i = 0 ;i< size;i++){
            if(name.equals(items[i].getName()))
            {
                return i;
            }
        }
        return -1; // if the Item doesn't exist
    }
    public static int searchIdCus(int id)
    {
        for (int i = 0 ;i<sizeCus;i++)
        {
            if (id == customers[i].getId())
            {
                return i;
            }
        }
        return -1 ; // if the Customer doesn't exist
    }
    public static int addItemCart(int id)
    {
        int un = -1;
        do {
        String data = "The Customer no : "+customers[id].getId()+" The Customer name is : "+ customers[id].getName() + "\n Item in the store \n" ;
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i< size ; i++)
        {
            list.add(items[i].getName());
            data+= "  "+(i+1)+"-    "+items[id].getId()+ "       "+ items[i].getName()+
            "      [ "+ items[i].getQuan()+"]  \n" ;

        }
        data+= ".........\n" +
                "0. Return to a main menu\n" +
                "Enter your item choice : ";
        String numCho = JOptionPane.showInputDialog(null,data);
        int num = Integer.parseInt(numCho);
        if(num == 0)
        {
            return 0;
        }else {
            String choose = " ",
                 nameItem = " ";
            int quan = 0,
                idItem = -1;

            for (int i = 0; i < size; i++) {
                
                if (list.get(num - 1).equals(items[i].getName())) {
                    quan = items[i].getQuan();
                    idItem = items[i].getId();
                    nameItem = items[i].getName();
                    choose = "The item is  [ " + idItem + "  " + nameItem + "  [" + quan + "] ]" +

                            "\n Enter the required quantity: ";
                    break;
                }
            }
           String ch = JOptionPane.showInputDialog(null, choose);
           int qu = Integer.parseInt(ch);

            if (quan >= qu && qu > 0 && quan != 0) {
                sales[sizeSal] = new Sale(customers[id].getId(), idItem, qu, nameItem);
                int total = quan - qu;
                int indexNameItem = searchNameItem(nameItem);
                items[indexNameItem].setQuan(total);
                sizeSal++;
                JOptionPane.showMessageDialog(null, "The item has been added in your cart");
                return -1;
            }
            String yN = JOptionPane.showInputDialog(null, "Sorry the required quantity is not available, the available quantity is [" + quan + "],try again! \n" +
                    "Do you want add another item to shopping cart (1/0)?");
            qu = Integer.parseInt(yN);
                 }
        } while (un == 1);
        return -1;
    }
    public static void removeAnItemFromCustomerShopping(int id)
    {
        int search = searchIdCus(id);
        if(search != -1)  // exists
        {
            ArrayList<Integer> indexSale = new ArrayList<>(); // return product index
            ArrayList<String> nameItemSale = new ArrayList<>(); // return product name
            String data = "The customer no : "+ customers[search].getId() + " The customer name : "+ customers[search].getName()+"\n";
            for (int i = 0 ;i< sizeSal;i++) {
                if (id == sales[i].getIdCustomer()) {
                    nameItemSale.add(sales[i].getNameItem());
                    indexSale.add(i);
                    data += "     " + (i + 1) + "-    " + sales[i].getIdItem() + "    " + sales[i].getNameItem() + "    " + sales[i].getQuan()+"\n";
                }
            }
            String data1 = "What you want to modify ?\n" +
                        "R. Remove item form the shopping cart.\n" +
                        "M. Return to the main menu.\n" +
                        "Enter your choice [R Remove, M main menu]: ";
                String ch = JOptionPane.showInputDialog(null,data+"\n"+data1);
                if (ch.toUpperCase().equals("M")) // Mein Menu
                {
                       return;
                }else if (ch.toUpperCase().equals("R")) // Remove
                {
                    String cH = JOptionPane.showInputDialog(null,data+"........\n 0. Return to the main menu.\n Enter Your item option number: \n ");
                    int Ch = Integer.parseInt(cH);
                    if (Ch == 0){return;}

                    String nameItem = nameItemSale.get(Ch-1);
                    String message = " The item ["+sales[indexSale.get(Ch-1)].getIdItem() + nameItem + " ["+ sales[indexSale.get(Ch-1)].getQuan()+"] ] is removed from shopping cart. \n";
                    int quan = deleteItem(nameItem,id);
                    int indexNameItem = searchNameItem(nameItem);
                    int total = items[indexNameItem].getQuan() + quan;
                    items[indexNameItem].setQuan(total);
                    JOptionPane.showMessageDialog(null,message);

                }

        } else  // not exists
        {
            JOptionPane.showMessageDialog(null,"The Customer doesn't registrar before");
        }
    }
    public static int deleteItem(String nameItem, int id)
    {
        for (int i = 0 ; i< sizeSal ;i++)
        {
            if (id == sales[i].getIdCustomer())
            {
                if (nameItem.equals(sales[i].getNameItem()))
                {
                    if (sizeSal-1 == i)
                    {
                        int quan = sales[i].getQuan();
                        sizeSal--;
                        return quan;
                    }
                    int quan = sales[i].getQuan();
                    sales[i] = sales[i+1];
                    sizeSal--;
                    return quan;
                }
            }
        }
        return 0;
    }
    public static void display(int id)
    {
        if (searchIdCus(id) != -1)
        {
            int totalPri = 0;
            String data = "Item no    Item name   Quantity   Unit price   Total price ";
            for(int i = 0 ;i<sizeCus ;i++)
            {
                if (id ==   sales[i].getIdCustomer()) {
                    int qu = sales[i].getQuan();
                    int index = searchNameItem(sales[i].getNameItem());
                    int total = qu * items[index].getPrice();
                    totalPri += total;
                    data += "\n      " + sales[i].getIdItem() + "                " + sales[i].getNameItem() + "              " + qu + "                   " + items[index].getPrice() + "                  " + total;
                }
            }
            data+= "\n\n                                 Price : " + totalPri;
            JOptionPane.showMessageDialog(null,data);
        }else
        {
            JOptionPane.showMessageDialog(null,"The Customer doesn't exists.");
        }
    }
    public static void endShoppingAndGoToCheckout(int id )
    {
        if (searchIdCus(id) != -1)
        {
            display(id);
            empty(id);
            for (int i = 0 ;i< sizeCus ; i++)
            {
                if(id == customers[i].getId())
                {
                    for (int j = i ;j< sizeCus;j++) {
                    if (sizeCus -1 == j)
                    {
                        sizeCus--;
                        JOptionPane.showMessageDialog(null,"The Customer Deleted");
                        break;
                    }
                        customers[i] = customers[i + 1];
                    }
                }
            }
            for(int i = 0 ;i< cart.length;i++)
            {
                if (id == cart[i])
                {
                    cart[i] = -1;
                    break;
                }
            }
        }else
        {
            JOptionPane.showMessageDialog(null,"The Customer doesn't exists");
        }
    }
    public static void empty(int id )
    {
        for (int i = 0 ; i < sizeSal ; i++)
        {
            if (id == sales[i].getIdCustomer())
            {
                for (int j = i ; j< sizeSal; j++)
                {
                    if (sizeSal- 1 == j)
                    {
                        sizeSal--;
                    }
                    sales[j] = sales[j+1];
                }
            }else
            {

            }
        }
    }
    public static void emptyCustomerShoppingCart(int id)
    {
        if (searchIdCus(id) != id)
        {
            for (int i = 0 ;i < sizeSal ; i++)
            {
                if (id == sales[i].getIdCustomer())
                {
                    int quBe = sales[i].getQuan();
                    int index = searchNameItem(sales[i].getNameItem());
                    int total = quBe + items[index].getQuan();
                    items[index].setQuan(total);
                    for (int j = i ; j < sizeSal ; j++)
                    {
                        if (sizeSal -1 == j)
                        {
                            sizeSal--;
                        }
                        sales[j] = sales[j+1];
                    }
                }
            }
            for(int i = 0 ;i < cart.length ;i++)
            {
                if (id == cart[i])
                {
                    cart[i] = -1;
                }
            }
            for (int i = 0 ; i< cart.length ;i++)
            {
                if (-1 == cart[i])
                {
                 cart[i] = id;
                }
            }
        }else
        {
            JOptionPane.showMessageDialog(null,"The Customer doesn't exists");
        }
    }
}
