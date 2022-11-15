public class Vehicle {
    private int id;
    private String license_plate;
    private String vehicle_type;
    private String gas_type;
    public Vehicle(int id ,String license_plate, String vehicle_type, String gas_type){
        this.id = id;
        this.license_plate = license_plate;
        this.vehicle_type = vehicle_type;
        this.gas_type = gas_type;
    }

    /**
     * setters y getters de las propiedades de la clase vehicle
     */
    public int getId() {
        return id;
    }
    public String getLicensePlate() {
        return license_plate;
    }
    public String getVehicleType() {
        return vehicle_type;
    }
    public String getGasType() {
        return gas_type;
    }
    public void setGas_type(String gas_type) {
        this.gas_type = gas_type;
    }
    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }
}
