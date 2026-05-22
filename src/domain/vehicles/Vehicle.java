package domain.vehicles;

public class Vehicle {

    private String model;
    private String brand;
    private float pricing;
    private float totalValue;

    public Vehicle(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setPricing(float pricing) {
        this.pricing = pricing;
    } 

    public float getPricing() {
        return this.pricing;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public float getTotalValue() {
        return this.totalValue;
    }
}