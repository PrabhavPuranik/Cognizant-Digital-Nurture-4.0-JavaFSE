package Week_1.Data_Structure.Ecommerce_Platform;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(1,"Mouse", "Electronics"),
                new Product(2,"Keyboard", "Electronics"),
                new Product(3,"Printer", "Electronics"),
                new Product(4,"Milk", "Dairy"),
                new Product(5,"Paneer", "Dairy"),
                new Product(6, "Cheese", "Dairy"),
                new Product(7, "Monitor", "Electronics"),
                new Product(8, "Yogurt", "Dairy"),
                new Product(9, "Laptop", "Electronics"),
                new Product(10, "Butter", "Dairy")
        };

        SearchFunction searchFunction= new SearchFunction();

        int linearSearchID = 10;
        long linearStart = System.nanoTime();
        Product linearSearchResult = searchFunction.LinearSearch(products, linearSearchID);
        long linearEnd = System.nanoTime();
        double linearDurationMs = (linearEnd - linearStart) / 1_000_000.0;
        System.out.println("========Linear Search========");
        Display(linearSearchResult);
        System.out.printf("Time taken: %.3f ms\n", linearDurationMs);

        int binarySearchID = 5;
        long binaryStart = System.nanoTime();
        Product BinarySearchResult = searchFunction.BinarySearch(products, binarySearchID);
        long binaryEnd = System.nanoTime();
        double binaryDurationMs = (binaryEnd - binaryStart) / 1_000_000.0;
        System.out.println("========Binary Search========");
        Display(BinarySearchResult);
        System.out.printf("Time taken: %.3f ms\n", binaryDurationMs);

    }
    public static void Display(Product product){
        if(product != null) {
            System.out.println("Product ID: " + product.getProductID());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Category: " + product.getProductCategory());
        }
        else{
            System.out.println("Product not found!");
        }
    }
}