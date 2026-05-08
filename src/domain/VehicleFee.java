package domain;

public enum VehicleFee {

    CAR(250),
    MOTORCYCLE(150),
    TRUCK(350);

    private final int hourFee;

    private VehicleFee(int hourFee) {
        this.hourFee = hourFee;
    }

    public int getHourFee(){
        return hourFee;
    }
}