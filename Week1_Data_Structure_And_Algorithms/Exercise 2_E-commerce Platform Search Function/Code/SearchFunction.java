package Week_1.Data_Structure.Ecommerce_Platform;

public class SearchFunction {

    public Product LinearSearch(Product[] products, int productID){
        for(var i : products){
            if(i.getProductID() == productID){
                return i;
            }
        }
        return null;
    }

    public Product BinarySearch(Product[] products, int productID){
        int low = 0;
        int high = products.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(products[mid].getProductID() == productID)
                return products[mid];
            else if(products[mid].getProductID() < productID)
                low = mid + 1;
            else high = mid - 1;


        }
        return null;
    }
}
