package Week_1.Data_Structure.Ecommerce_Platform;

public class Product {

    private final int productID;
    private String productName;
    private String category;

    public Product(int productID, String productName, String category){
        this.productID = productID;
        this.productName = productName;
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return category;
    }
}
