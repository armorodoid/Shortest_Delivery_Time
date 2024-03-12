import java.util.List;
public class AddDeliveryDetails {
    private static int i;
    public void addDeliveryDetails(List<DeliveryDetails> pickup) {
        pickup.add(new DeliveryDetails(new Coordinates(0,5),
                new Coordinates(10,0),
                ++i, 5));

        pickup.add(new DeliveryDetails(new Coordinates(10,5),
                new Coordinates(1,5),
                ++i, 15));

        pickup.add(new DeliveryDetails(new Coordinates(0,0),
                new Coordinates(9,4),
                ++i, 0));

        pickup.add(new DeliveryDetails(new Coordinates(10,5),
                new Coordinates(0,0),
                ++i, 5));
    }
}
