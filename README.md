# FastFoodKitchen Management System

## Overview
The **FastFoodKitchen Management System** is a Java-based application designed to manage orders in a fast-food restaurant. It allows staff to:

- Place and manage customer orders.
- Update and complete existing orders.
- Search for orders based on specific criteria.
- Generate reports for pending orders at the end of the day.
- Track customer loyalty and order statistics.

This system uses **CSV files** to load initial data (`BurgerOrders.csv`) and to save pending orders (`BurgerOrders2.csv`) dynamically.

---

## Features

### 1. **Order Management**
- Add new orders with details such as the number of items, customer name, and whether it is a takeout order.
- Update existing orders.
- Cancel or complete orders.

### 2. **Search Functionality**
- Search for orders based on whether they are to-go and the minimum number of items.

### 3. **Statistics and Insights**
- Calculate the average number of items per order.
- Track customer loyalty by showing how many orders each customer has placed.

### 4. **Report Generation**
- Generate a CSV file (`BurgerOrders2.csv`) containing all pending orders at the end of the day.

### 5. **Data Persistence**
- Load initial order data from `BurgerOrders.csv`.
- Save pending orders dynamically to `BurgerOrders2.csv`.

---


## How to Run

1. Navigate to the `FastFoodKitchenDriver` class.
2. Run the `main` method.
3. Follow the prompts in the console to interact with the system.


## Features in Detail

### Menu Options
When the program is run, the following menu is displayed:

Please select from the following menu:
1. Order food
2. Cancel order
3. Show pending orders
4. Complete order
5. Update an order
6. Search orders by criteria
7. Show loyalty program details
8. Show average items per order
9. Exit

### Example Interaction
1. Add a new order:
   - Input details such as the number of items, customer name, and whether the order is to-go.
2. Complete an order:
   - Mark an order as complete, removing it from the pending list.
3. Generate pending orders report:
   - Automatically create a CSV file (`BurgerOrders2.csv`) at the end of the program.

---

## License
This project is licensed under the [MIT License](LICENSE).

---

## Authors
- **Sai Khushal Dulam**: Project Design and Development
