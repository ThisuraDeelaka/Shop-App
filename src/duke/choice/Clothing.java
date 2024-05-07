package duke.choice;

public class Clothing implements Comparable<Clothing>{

    private String description;

    public Clothing(String description, double price, String size) {
        this.description = description;
        this.price = price;
        this.size = size;
    }

    private double price;
    private String size = "M";
    public static final double MIN_PRICE = 10;
    public static final double TAX_RATE = 0.2;

//    void print_details(String des, double p, String s){
//        System.out.println("Description - " + des + "\n" + "Price - " + p + "\n" + "Size - " + s + "\n");
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price * (1 + TAX_RATE);
    }

    public void setPrice(double price) {
        this.price = Math.max(price, MIN_PRICE);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return getDescription() + ", " + getPrice() + ", " + getSize();
    }

    @Override
    public int compareTo (Clothing c) {
        return this.description.compareTo(c.description);
    }
}
