package OrderProcessingSystem;

import java.util.*;

// Item class
class Item {
    String name;
    double price;
    int quantity;
    int reorderLevel;

    Item(String name, double price, int quantity, int reorderLevel) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }
}

// Customer class
class Customer {
    String name, address, phone, email;

    Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}

// Order class
class Order {
    int orderId;
    Customer customer;
    Map<Item, Integer> items = new HashMap<>();
    Date date;
    double totalAmount = 0;

    Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.date = new Date();
    }

    void addItem(Item item, int qty) {
        items.put(item, qty);
        totalAmount += item.price * qty;
    }
}

public class OrderProcessingSystem {

    static Scanner sc = new Scanner(System.in);

    static List<Item> itemList = new ArrayList<>();
    static List<Customer> customerList = new ArrayList<>();
    static List<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {

        // sample data
        itemList.add(new Item("Pen", 10, 50, 5));
        itemList.add(new Item("Book", 100, 20, 5));
        itemList.add(new Item("Pencil", 5, 2, 5));

        customerList.add(new Customer("Rihitha", "AP", "1234567890", "rihitha@gmail.com"));

        int choice;

        do {
            System.out.println("\n===== ORDER SYSTEM MENU =====");
            System.out.println("1. Place Order");
            System.out.println("2. Search Item by Name");
            System.out.println("3. Search Item by Price");
            System.out.println("4. Get Order by ID");
            System.out.println("5. Get Orders by Customer");
            System.out.println("6. Highest Order");
            System.out.println("7. Lowest Order");
            System.out.println("8. Last Week Orders");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    placeOrder();
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    String name = sc.next();
                    findItemByName(name);
                    break;

                case 3:
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    findItemsByPrice(price);
                    break;

                case 4:
                    System.out.print("Enter order id: ");
                    int id = sc.nextInt();
                    getOrderById(id);
                    break;

                case 5:
                    System.out.print("Enter customer name: ");
                    String cname = sc.next();
                    getOrdersByCustomer(cname);
                    break;

                case 6:
                    highestOrder();
                    break;

                case 7:
                    lowestOrder();
                    break;

                case 8:
                    lastWeekOrders();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 9);
    }

    // place order
    static void placeOrder() {
        System.out.print("Enter order id: ");
        int id = sc.nextInt();

        Customer c = customerList.get(0);

        System.out.print("Enter item name: ");
        String itemName = sc.next();

        Item selected = null;

        for (Item i : itemList) {
            if (i.name.equalsIgnoreCase(itemName)) {
                selected = i;
            }
        }

        if (selected == null) {
            System.out.println("Item not found. Available items are:");
            for (Item i : itemList) {
                System.out.println("- " + i.name);
            }
            return;
        }

        if (selected.quantity <= selected.reorderLevel) {
            System.out.println("Stock low. Cannot place order.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        if (qty > selected.quantity) {
            System.out.println("Not enough stock");
            return;
        }

        Order order = new Order(id, c);
        order.addItem(selected, qty);

        selected.quantity -= qty;
        orderList.add(order);

        System.out.println("Order placed successfully");
    }

    static void findItemByName(String name) {
        boolean found = false;

        for (Item i : itemList) {
            if (i.name.equalsIgnoreCase(name)) {
                System.out.println("Item: " + i.name + " Price: " + i.price);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Item not found");
        }
    }

    static void findItemsByPrice(double price) {
        boolean found = false;

        for (Item i : itemList) {
            if (i.price == price) {
                System.out.println("Item: " + i.name);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No items found with this price");
        }
    }

    static void getOrderById(int id) {
        boolean found = false;

        for (Order o : orderList) {
            if (o.orderId == id) {
                System.out.println("Order Found: " + o.orderId + " Amount: " + o.totalAmount);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Order not found");
        }
    }

    static void getOrdersByCustomer(String name) {
        boolean found = false;

        for (Order o : orderList) {
            if (o.customer.name.equalsIgnoreCase(name)) {
                System.out.println("Order ID: " + o.orderId);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No orders found for this customer");
        }
    }

    static void highestOrder() {
        if (orderList.isEmpty()) {
            System.out.println("No orders available");
            return;
        }

        Order max = orderList.get(0);

        for (Order o : orderList) {
            if (o.totalAmount > max.totalAmount) {
                max = o;
            }
        }

        System.out.println("Highest Order ID: " + max.orderId);
    }

    static void lowestOrder() {
        if (orderList.isEmpty()) {
            System.out.println("No orders available");
            return;
        }

        Order min = orderList.get(0);

        for (Order o : orderList) {
            if (o.totalAmount < min.totalAmount) {
                min = o;
            }
        }

        System.out.println("Lowest Order ID: " + min.orderId);
    }

    static void lastWeekOrders() {
        if (orderList.isEmpty()) {
            System.out.println("No orders available");
            return;
        }

        Date now = new Date();
        boolean found = false;

        for (Order o : orderList) {
            long diff = now.getTime() - o.date.getTime();
            long days = diff / (1000 * 60 * 60 * 24);

            if (days <= 7) {
                System.out.println("Recent Order ID: " + o.orderId);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No orders in last week");
        }
    }
}