import java.util.ArrayList;

public class Category {
    private String categoryName;
    public Product products;

    public Category(String categoryName, Product products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    public Category(String productName, double calories, double protein, double fat, double carbs, double sugar) {
        this.products = new Product(productName, calories, protein, fat, carbs, sugar);
    }

    @Override
    public String toString() {  return categoryName + ";  " + products.getProductName(); }

    public String csvFormat() { return categoryName + ";" + products.csvFormat();}

    public String getCategoryName() {
        return categoryName;
    }

    public Product getProduct() {
        return products;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public void setProducts(Product products) { this.products = products; }
}
