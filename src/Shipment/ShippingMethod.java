package Shipment;

public interface ShippingMethod {
    public String estimatePrice(int weight, int distance);
    public static ShippingMethod from(ShippingMethodType type){
        ShippingMethod shippingMethod = new CarShippingMethod();
            switch (type){
                case CAR -> shippingMethod = new CarShippingMethod();
                case SHIP -> shippingMethod = new ShipShippingMethod();
                default -> {}
            }
            return shippingMethod;
    }
}
