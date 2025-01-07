import java.util.*;

public class FastFoodKitchenDriver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            FastFoodKitchen kitchen = new FastFoodKitchen("burgerOrders.csv");

            while (true) {
                System.out.println("\nPlease select from the following menu:");
                System.out.println("1. Order food");
                System.out.println("2. Cancel order");
                System.out.println("3. Show pending orders");
                System.out.println("4. Complete order");
                System.out.println("5. Update an order");
                System.out.println("6. Search orders by criteria");
                System.out.println("7. Show loyalty program details");
                System.out.println("8. Show average items per order");
                System.out.println("9. Exit");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter number of hamburgers:");
                        int ham = sc.nextInt();
                        System.out.println("Enter number of cheeseburgers:");
                        int cheese = sc.nextInt();
                        System.out.println("Enter number of veggieburgers:");
                        int veggie = sc.nextInt();
                        System.out.println("Enter number of sodas:");
                        int sodas = sc.nextInt();
                        System.out.println("Is this order to go? (true/false):");
                        boolean toGo = sc.nextBoolean();
                        System.out.println("Enter customer name:");
                        String customerName = sc.next();
                        System.out.println("Enter customer phone:");
                        String customerPhone = sc.next();

                        int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, toGo, customerName, customerPhone);
                        System.out.println("Order placed successfully. Your order number is: " + orderNum);
                    }
                    case 2 -> {
                        System.out.println("Enter the order number to cancel:");
                        int orderID = sc.nextInt();
                        if (kitchen.cancelOrder(orderID)) {
                            System.out.println("Order canceled successfully.");
                        } else {
                            System.out.println("Order not found.");
                        }
                    }
                    case 3 -> System.out.println("Number of pending orders: " + kitchen.getNumOrdersPending());
                    case 4 -> {
                        System.out.println("Enter the order number to complete:");
                        int orderID = sc.nextInt();
                        kitchen.completeSpecificOrder(orderID);
                        System.out.println("Order completed successfully.");
                    }
                    case 5 -> {
                        System.out.println("Enter the order number to update:");
                        int orderID = sc.nextInt();
                        System.out.println("Enter new number of hamburgers:");
                        int ham = sc.nextInt();
                        System.out.println("Enter new number of cheeseburgers:");
                        int cheese = sc.nextInt();
                        System.out.println("Enter new number of veggieburgers:");
                        int veggie = sc.nextInt();
                        System.out.println("Enter new number of sodas:");
                        int sodas = sc.nextInt();

                        if (kitchen.updateOrder(orderID, ham, cheese, veggie, sodas)) {
                            System.out.println("Order updated successfully.");
                        } else {
                            System.out.println("Order not found.");
                        }
                    }
                    case 6 -> {
                        System.out.println("Search for to-go orders? (true/false):");
                        boolean toGo = sc.nextBoolean();
                        System.out.println("Enter minimum number of items in the order:");
                        int minItems = sc.nextInt();
                        ArrayList<BurgerOrder> results = kitchen.searchOrdersByCriteria(toGo, minItems);
                        System.out.println("Matching orders:");
                        for (BurgerOrder order : results) {
                            System.out.println(order);
                        }
                    }
                    case 7 -> kitchen.printLoyaltyProgramDetails();
                    case 8 -> {
                        double avgItems = kitchen.calculateAverageItemsPerOrder();
                        System.out.println("Average number of items per order: " + avgItems);
                    }
                    case 9 -> {
                        kitchen.generateEndOfDayReport();
                        System.out.println("Exiting the application. Goodbye!");
                        sc.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
