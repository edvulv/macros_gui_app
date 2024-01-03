public class Date {
    public String month;
    public int day;
    public int year;
    public Product product;

    public Date(String month, int day, int year, Product product) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.product = product;
    }

    @Override
    public String toString() {
        return month + ";" + day + ";" + year + ";" + product.getProductName() + ";" + product.getCalories() + ";" + product.getProtein() + ";" + product.getFat() + ";" + product.getCarbs() + ";" + product.getSugar();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(String productName, double calories, double protein, double fat, double carbs, double sugar) {
        this.product = new Product(productName, calories, protein, fat, carbs, sugar);
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
