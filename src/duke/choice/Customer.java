package duke.choice;

import java.util.Objects;

public class Customer {
    private String name;

    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }

    private String size;

    private Clothing[] items;

    void greetCustomer(String cName) {
        System.out.println("Hello " + cName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSize(int measurement) {
        switch (measurement) {
            case 1, 2, 3:
                setSize("S");
                break;

            case 4, 5, 6:
                setSize("M");
                break;

            case 7, 8, 9:
                setSize("L");
                break;

            default:
                setSize("X");
        }
    }

    public Clothing[] getItems() {
        return items;
    }

    public void setItems(Clothing[] items) {
        this.items = items;
    }

    public double getTotalCloathingCost() {
        double total = 0.0;
        for (Clothing item : items) {
//            if (c1.getSize().equals(item.getSize())) {
//            System.out.println(item.getDescription() + "\n" + item.getPrice() + "\n" + item.getSize());
                total = total + (item.getPrice());
//                if (total > 25){
//                    break;
//                }
            //           }
        }
        return total;
    }
}
