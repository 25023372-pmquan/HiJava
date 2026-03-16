package Shipment;

public class CarShippingMethod implements ShippingMethod{
    @Override
    public String estimatePrice(int weight, int distance) {
        int price = 30 * distance * weight;
        return ("total: " + price);
    }
}
