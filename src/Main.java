import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Double time = 0.0;
    public static void main(String[] args) {

        System.out.println("Hello and Welcome!");
        Coordinates deliveryPartner = new Coordinates(12.95,77.6);
        List<DeliveryDetails> pickup = new ArrayList<>();

        AddDeliveryDetails aDD = new AddDeliveryDetails();
        int expResult = aDD.addDeliveryDetails(pickup);

        Delivery del = new Delivery();
        int result = (int) del.startDelivery(pickup,time,deliveryPartner);

        if (expResult == result)
            System.out.println("Test passed");
    }
}