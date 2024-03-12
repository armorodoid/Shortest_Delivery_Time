import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Double time = 0.0;
    public static Coordinates deliveryPartner;
    public static void main(String[] args) {

        System.out.println("Hello and Welcome!");
        deliveryPartner = new Coordinates(0,0);
        List<DeliveryDetails> pickup = new ArrayList<>();
        List<DeliveryDetails> deliver = new ArrayList<>();

        AddDeliveryDetails aDD = new AddDeliveryDetails();
        aDD.addDeliveryDetails(pickup);

        Delivery del = new Delivery();
        System.out.println("Total Time Taken: " + del.startDelivery(pickup,time,deliveryPartner));
    }
}