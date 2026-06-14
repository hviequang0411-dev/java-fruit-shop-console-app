package controller;

import model.Fruit;
import model.OrderItem;
import valation.validation;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class FruitManagement {
    private final List<Fruit> fruitList;
    private final  Hashtable<String,List<OrderItem>> orders;
    public FruitManagement() {
        fruitList = new ArrayList<>();
        orders = new Hashtable<>();
    }
    public boolean isDuplicateId(String id){
        for(Fruit fruit : fruitList){
            if(fruit.getFruitId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public  void createFruit(){
        while(true){
            System.out.print("\n===Create Fruit====\n");
            String id;
            while (true){
            id = validation.getString("Enter Fruit ID: ");
            if(!isDuplicateId(id)){
                break;
            }
            System.out.print("\nId alredy exists!\n");
            }
            String name =
                    validation.getString(
                            "Enter fruit name: ");

            double price =
                    validation.getDouble(
                            "Enter price: ",
                            0.1,
                            Double.MAX_VALUE
                    );

            int quantity =
                    validation.getInt(
                            "Enter quantity: ",
                            1,
                            Integer.MAX_VALUE
                    );

            String origin =
                    validation.getString(
                            "Enter origin: ");
            fruitList.add(
                    new Fruit(
                            id,
                            name,
                            price,
                            quantity,
                            origin
                    )
            );

            System.out.println(
                    "Create fruit successfully!");

            boolean cont =
                    validation.getYesNo(
                            "Continue (Y/N): ");

            if (!cont) {
                displayFruits();
                return;
            }


        }

    }
    public void displayFruits(){
        System.out.println("\n===Display Fruits====");
        System.out.printf(
                "%-10s %-15s %-15s %-10s %-10s\n",
                "Item",
                "Fruit Name",
                "Origin",
                "Price",
                "Quantity"
        );
       int item=1;
       for(Fruit fruit : fruitList){


               System.out.printf(
                       "%-10d %-15s %-15s %-10.2f %-10d\n",
                       item++,
                       fruit.getFruitName(),
                       fruit.getOrigin(),
                       fruit.getPrice(),
                       fruit.getQuantity()
               );

       }
  }
  public void shopping(){
        if(fruitList.isEmpty()){
            System.out.println("Empty fruits!");
        }
        List<OrderItem> cart = new ArrayList<>();
        while(true){
            displayFruits();
            int item = validation.getInt("Select Item ", 1, fruitList.size());
            Fruit selectedFruit = fruitList.get(item-1);
            System.out.printf("\nSelect item: \n"+fruitList.get(item-1).getFruitName());
            if(selectedFruit.getQuantity()==0){
                System.out.println("\nOut of stock!\n");
                continue;
            }
            int quantity = validation.getInt("\nEnter quantity\n",1,selectedFruit.getQuantity());
            cart.add(new OrderItem(selectedFruit.getFruitName(),quantity,selectedFruit.getPrice()));
            selectedFruit.setQuantity(selectedFruit.getQuantity()-quantity);
            System.out.println("\n Add to cart\n");
            boolean orderNow =  validation.getYesNo("Do u want 2 oreder now [Y/N]");
            if(orderNow){
                String customerName = validation.getString("Enter customer name: ");
                orders.put(customerName, cart);
                System.out.println("\nOrder added successfully!\n");
                return;
            }
        }
  }


    public void addFruit() {

        String id =
                validation.getString(
                        "Enter Fruit ID: ");

        Fruit foundFruit = null;

        // tìm fruit
        for (Fruit fruit : fruitList) {

            if (fruit.getFruitId()
                    .equalsIgnoreCase(id)) {

                foundFruit = fruit;
                break;
            }
        }

        // không tìm thấy
        if (foundFruit == null) {

            System.out.println(
                    "Fruit not found!");

            return;
        }

        int quantity =
                validation.getInt(
                        "Enter amount: ",
                        1,
                        100
                );

        foundFruit.setQuantity(
                foundFruit.getQuantity()
                        + quantity
        );

        System.out.println(
                "Add quantity successfully!");

        displayFruits();
    }

    public void viewOrder(){
        if(orders.isEmpty()){
            System.out.println("\nNo orders found!\n");
            return;
        }
        for(String customer : orders.keySet()){

            System.out.println("\nCustomer" + customer);
            System.out.println("Product | Quantity | Price | Amount\n");
            double total = 0;
            List<OrderItem> cart = orders.get(customer);
            for(OrderItem item : cart){
                System.out.println(item);
                total += item.getAmount();
            }
            System.out.println("Total: " + total + "$");
        }

    }

    public void run() {
        int choice =
                validation.getInt(
                        "Enter choice: ",
                        1,
                        5
                );

        switch (choice) {

            case 1:
                createFruit();
                break;

            case 2:
                viewOrder();
                break;

            case 3:
                shopping();
                break;
            case 4:
                addFruit();
                break;

            case 5:
                System.exit(0);
        }


    }}
