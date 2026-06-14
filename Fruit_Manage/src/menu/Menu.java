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
                    "5. Exit");


            fruitManagement.run();
            }
        }
    }

