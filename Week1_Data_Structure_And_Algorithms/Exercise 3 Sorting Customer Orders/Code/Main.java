package Week_1.Data_Structure.Sorting_Customer_Orders;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Raj", 2500),
                new Order(2, "Priya", 1200),
                new Order(3, "Anjali", 3400),
                new Order(4, "Amit", 1800),
                new Order(5, "Rahul", 1700),
                new Order(6, "Neha", 4500)
        };

        Order[] bubbleSortedOrders = orders.clone();
        long startBubble = System.currentTimeMillis();
        BubbleSort.sort(bubbleSortedOrders);
        long endBubble = System.currentTimeMillis();
        System.out.println("======== Bubble Sort ========");
        displayOrders(bubbleSortedOrders);
        System.out.println("Bubble Sort Time: " + (endBubble - startBubble) + " ms\n");

        Order[] quickSortedOrders = orders.clone();
        long startQuick = System.currentTimeMillis();
        QuickSort.sort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        long endQuick = System.currentTimeMillis();
        System.out.println("======== Quick Sort ========");
        displayOrders(quickSortedOrders);
        System.out.println("Quick Sort Time: " + (endQuick - startQuick) + " ms");
    }

    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("OrderID: " + order.getOrderId() + ", Name: " + order.getCustomerName() +
                    ", Price: " + order.getTotalPrice());
        }

    }
}
