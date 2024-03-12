import java.util.*;

public class Delivery {
    private double calculateDistance(Coordinates a, Coordinates b) {
        int distSquare = ((b.x-a.x)*(b.x-a.x)) + ((b.y-a.y)*(b.y-a.y));
        return Math.sqrt(distSquare);
    }
    public Double startDelivery(List<DeliveryDetails> pickup, Double time, Coordinates deliveryPartner) {
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
