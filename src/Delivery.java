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
        double speed = 20.0/60;

        while(!pickup.isEmpty()) {
            List<RelativeDist> ls = new ArrayList<>();

            for (DeliveryDetails x : pickup) {
                double timeReq;
                if (x.orderPicked) {
                    timeReq = calculateDistance(x.customer, deliveryPartner) / speed;
                } else {
                    double temp = calculateDistance(x.restaurant, deliveryPartner) / speed;
                    timeReq = Math.max(temp, x.preparationTime-time);
                }
                ls.add(new RelativeDist(timeReq, x));
            }

            Collections.sort(ls, new Comparator<RelativeDist>() {
                @Override
                public int compare(RelativeDist a, RelativeDist b) {
                    if (a.timeReq>b.timeReq)
                        return 1;
                    else if (a.timeReq==b.timeReq)
                        return 0;
                    else
                        return -1;
                }
            });

            RelativeDist x = ls.get(0);
            time+=x.timeReq;
            if (x.dd.orderPicked) {
                pickup.remove(x.dd);
                x.dd.setLogCustomers(time);
                deliveryPartner = x.dd.customer;
            } else {
                x.dd.orderPicked=true;
                x.dd.setLogRestaurants(time);
                deliveryPartner = x.dd.restaurant;
            }
        }
        return time;
    }
}
