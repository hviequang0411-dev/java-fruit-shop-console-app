package menu;

import controller.FruitManagement;
import valation.validation;

public class Menu {
    public static void displayMenu() {
        FruitManagement fruitManagement = new FruitManagement();
        while (true) {

            System.out.println(
                    "\n===== FRUIT SHOP SYSTEM =====");

            System.out.println(
                    "1. Create Fruit");


            System.out.println(
                    "2. View Orders");

            System.out.println(
                    "3. Shopping");
            System.out.println(
                    "4. Add Fruit");



            System.out.println(
                    "5. Exit");

//            int choice =
//                    validation.getInt(
//                            "Enter choice: ",
//                            1,
//                            4
//                    );
//
//            switch (choice) {
//
//                case 1:
//                    fruitManagement.createFruit();
//                    break;
//
//                case 2:
//                    fruitManagement.viewOrder();
//                    break;
//
//                case 3:
//                    fruitManagement.shopping();
//                    break;
//
//                case 4:
//                    System.exit(0);
            fruitManagement.run();
            }
        }
    }

