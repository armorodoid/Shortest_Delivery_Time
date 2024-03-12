import java.util.*;

public class Delivery {

    //Haversine Formula
    private double calculateDistance(Coordinates a, Coordinates b) {
        double lat1 = b.x;
        double lat2 = a.x;
        double lon1 = b.y;
        double lon2 = a.y;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double z = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(z));
        return rad * c;
    }
    public double startDelivery(List<DeliveryDetails> pickup, Double time, Coordinates deliveryPartner) {
        double speed = 20.0/60; //converted speed to km/min

        while(!pickup.isEmpty()) {
            DeliveryDetails next = pickup.get(0);
            double nextTime = Double.MAX_VALUE;

            for (DeliveryDetails x : pickup) {
                double timeReq;
                if (x.orderPicked) {
                    timeReq = calculateDistance(x.customer, deliveryPartner) / speed;
                } else {
                    double temp = calculateDistance(x.restaurant, deliveryPartner) / speed;
                    timeReq = Math.max(temp, x.preparationTime-time);
                }

                if (timeReq<nextTime) { // Checking for nearest location
                    next = x;
                    nextTime = timeReq;
                }
            }

            time+=nextTime;
            if (next.orderPicked) {
                pickup.remove(next);
                next.setLogCustomers(time);
                deliveryPartner = next.customer;
            } else {
                next.orderPicked=true;
                next.setLogRestaurants(time);
                deliveryPartner = next.restaurant;
            }
        }
        return time;
    }
}
