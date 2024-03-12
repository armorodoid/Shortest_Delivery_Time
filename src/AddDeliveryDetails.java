import java.util.List;
public class AddDeliveryDetails {
    private static int i;
    public void addDeliveryDetails(List<DeliveryDetails> pickup) {
        pickup.add(new DeliveryDetails(new Coordinates(12.934533,77.626579),
                new Coordinates(12.954533,77.696579),
                ++i, 10));

        pickup.add(new DeliveryDetails(new Coordinates(12.93,77.8),
                new Coordinates(12.935,77.69),
                ++i, 15));

        pickup.add(new DeliveryDetails(new Coordinates(12.95,77.6),
                new Coordinates(12.937,77.8),
                ++i, 0));

        pickup.add(new DeliveryDetails(new Coordinates(12.93,77.55),
                new Coordinates(12.95,77.6),
                ++i, 5));
    }
}
