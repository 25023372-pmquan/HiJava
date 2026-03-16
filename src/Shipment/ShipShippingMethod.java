package Shipment;

public class ShipShippingMethod implements ShippingMethod {
    @Override
    public String estimatePrice(int weight, int distance) {
        int price = 50 * distance * weight;
        return ("total: " + price);
    }
}
