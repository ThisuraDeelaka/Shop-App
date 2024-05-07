package duke.choice;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

public class ShopApp {

    public static void main(String[] arg){

//        double tax = 0.2;
//        double total = 0;
        int measurement = 3;

        System.out.println("Minimum value = $" + Clothing.MIN_PRICE);
        Customer c1 = new Customer("Pinky", measurement);
//        c1.setName("Pinky");
//        c1.setSize(measurement);
        c1.greetCustomer(c1.getName());

        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");
        Clothing item3 = new Clothing("Green Scarf", 5, "S");
        Clothing item4 = new Clothing("Blue T-Shirt", 10.5, "S");

        Clothing [] items = {item1, item2, item3, item4};

        try {
            ItemList list = new ItemList(items);
            Routing routing = Routing.builder().get("/items", list).build();
            ServerConfiguration config =ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost()).port(8888).build();
            WebServer ws = WebServer.create(config, routing);
            ws.start();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

//        item1.setDescription("Blue Jacket");
//        item1.setPrice(20.9);
//
//        item2.setDescription("Orange T-Shirt");
//        item2.setPrice(10.5);
//        item2.setSize("S");
//
//        item3.setDescription("Green Scarf");
//        item3.setPrice(5);
//        item3.setSize("S");
//
//        item4.setDescription("Blue T-Shirt");
//        item4.setPrice(10.5);
//        item4.setSize("S");

        c1.setItems(items);
//        item1.print_details(item1.description, item1.price, item1.size);
//        item1.print_details(item2.description, item2.price, item2.size);

//        total = ((item2.price * 2) + item1.price) * (1 + tax);
        System.out.println("Customer is - " + c1.getName() + ", Customer size - " + c1.getSize() + "\nTotal - " + c1.getTotalCloathingCost());
//        System.out.println(Clothing.toString());

        int average = 0;
        int count = 0;

        for (Clothing item : c1.getItems()){
            System.out.println("Items - " + item.toString());
            if (item.getSize().equals("L")) {
                count++;
                average += item.getPrice();
            }
        }
        try {
            average = average / count;
            System.out.println("Average is - " + average + "\nCount - " + count);
        }catch (ArithmeticException e) {
            System.out.println("Don't devided by zero.");
        }

        Arrays.sort(c1.getItems());
        for (Clothing item : c1.getItems()) {
            System.out.println("Items - " + item.toString());
        }
    }
}
