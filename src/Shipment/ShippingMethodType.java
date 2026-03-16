package Shipment;

public enum ShippingMethodType {
    CAR("car"),
    AIRPLANE("plane"),
    SHIP("ship");
    private final String shippingMethodName;

    ShippingMethodType(String shippingMethodName) {
        this.shippingMethodName = shippingMethodName;
    }

    public String getShippingMethodName() {
        return shippingMethodName;
    }
}
