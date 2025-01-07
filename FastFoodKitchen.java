import java.io.*;
import java.util.*;


public class FastFoodKitchen {

    private ArrayList<BurgerOrder> orderList = new ArrayList<>();
    private static int nextOrderNum = 1;

    public FastFoodKitchen(String burgerOrdersFilename) {
        loadOrdersFromCSV(burgerOrdersFilename);
    }

    private void loadOrdersFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }
                String[] values = line.split(",");
                int numHamburgers = Integer.parseInt(values[0].trim());
                int numCheeseburgers = Integer.parseInt(values[1].trim());
                int numVeggieburgers = Integer.parseInt(values[2].trim());
                int numSodas = Integer.parseInt(values[3].trim());
                boolean orderToGo = Boolean.parseBoolean(values[4].trim());
                int orderNum = Integer.parseInt(values[5].trim());
                String customerName = values.length > 6 ? values[6].trim() : "Unknown";
                String customerPhone = values.length > 7 ? values[7].trim() : "Unknown";

                orderList.add(new BurgerOrder(numHamburgers, numCheeseburgers, numVeggieburgers, numSodas, orderToGo, orderNum, customerName, customerPhone));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static int getNextOrderNum() {
        return nextOrderNum;
    }

    private void incrementNextOrderNum() {
        nextOrderNum++;
    }

    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo, String customerName, String customerPhone) {
        int orderNum = getNextOrderNum();
        orderList.add(new BurgerOrder(ham, cheese, veggie, soda, toGo, orderNum, customerName, customerPhone));
        incrementNextOrderNum();
        return orderNum;
    }

    public boolean updateOrder(int orderID, int newHamburgers, int newCheeseburgers, int newVeggieburgers, int newSodas) {
        for (BurgerOrder order : orderList) {
            if (order.getOrderNum() == orderID) {
                order.setNumHamburger(newHamburgers);
                order.setNumCheeseburgers(newCheeseburgers);
                order.setNumVeggieburgers(newVeggieburgers);
                order.setNumSodas(newSodas);
                return true;
            }
        }
        return false;
    }

    public ArrayList<BurgerOrder> searchOrdersByCriteria(boolean toGo, int minItems) {
        ArrayList<BurgerOrder> results = new ArrayList<>();
        for (BurgerOrder order : orderList) {
            if (order.isOrderToGo() == toGo && order.getTotalBurgers() >= minItems) {
                results.add(order);
            }
        }
        return results;
    }

    public double calculateAverageItemsPerOrder() {
        if (orderList.isEmpty()) return 0.0;
        int totalItems = 0;
        for (BurgerOrder order : orderList) {
            totalItems += order.getTotalBurgers();
        }
        return (double) totalItems / orderList.size();
    }

    public void printLoyaltyProgramDetails() {
        Map<String, Integer> customerOrders = new HashMap<>();
        for (BurgerOrder order : orderList) {
            customerOrders.put(order.getCustomerName(), customerOrders.getOrDefault(order.getCustomerName(), 0) + 1);
        }
        System.out.println("Loyalty Program - Number of Orders per Customer:");
        for (Map.Entry<String, Integer> entry : customerOrders.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public boolean cancelOrder(int orderID) {
        return orderList.removeIf(order -> order.getOrderNum() == orderID);
    }

    public int getNumOrdersPending() {
        return orderList.size();
    }

    public void completeSpecificOrder(int orderID) {
        orderList.removeIf(order -> order.getOrderNum() == orderID);
    }

    public void generateEndOfDayReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("endOfDayReport.txt"))) {
            writer.write("End of Day Report\n\n");
            for (BurgerOrder order : orderList) {
                writer.write(order.toString() + "\n");
            }
            System.out.println("End-of-day report generated: endOfDayReport.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
