public class Product {
    protected String productName;
    protected double calories;
    protected double protein;
    protected double fat;
    protected double carbs;
    protected double sugar;

    public Product(String productName, double calories, double protein, double fat, double carbs, double sugar) {
        this.productName = productName;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "Product: " + productName /* + ", " + calories + ", " + protein + ", " + fat + ", " + carbs + ", " + sugar*/;
    }

    public String csvFormat() {
        return productName + ";" + calories + ";" + protein + ";" + fat + ";" + carbs + ";" + sugar;
    }

    public String addFormat() {
        return productName + ":" + calories + ":" + protein + ":" + fat + ":" + carbs + ":" + sugar;
    }

    public String prodmadestring(float amount) {
        return "Product: " + productName + " x" + amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCalories() { return calories; }

    public void setCalories(double calories) { this.calories = calories; }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }
}

