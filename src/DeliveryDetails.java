public class DeliveryDetails {
    Coordinates restaurant;
    Coordinates customer;
    int deliveryNumber;
    int preparationTime; //in minutes
    boolean orderPicked;

    public DeliveryDetails(Coordinates restaurant, Coordinates customer, int deliveryNumber, int preparationTime) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.deliveryNumber = deliveryNumber;
        this.preparationTime = preparationTime;
        this.orderPicked = false;
        System.out.println("Delivery Details " + this.deliveryNumber + " added");
    }

    public void setLogRestaurants(double time) {
        this.orderPicked = true;
        System.out.println("Delivery Number " + deliveryNumber + ": Order Picked Up at " + time);
    }

    public void setLogCustomers(double time ) {
        System.out.println("Delivery Number " + deliveryNumber + ": Order Delivered at " + time);
    }
}
