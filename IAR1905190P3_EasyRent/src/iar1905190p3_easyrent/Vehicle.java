 
package iar1905190p3_easyrent;
 
public abstract class Vehicle implements Comparable<Vehicle> {

    protected String license_number;
    protected String make;
    protected String model;
    protected double price;
  //---------------------------------------------------------------------
    public Vehicle(String license_number, String make, String model, double price) {
        this.license_number = license_number;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    //----------abstract method------------------------------------
    public abstract String getLicense_number();
    public abstract double CalcPrice();
    //-------------------------------------------------------------
    
    public String getVehicleName() {
        return make + " " + model;
    }

     
//-----------------------------------------------------------------
    @Override
    public String toString() {
        return "\n\tLicense # : " + license_number + "\n\tVehicle Name : " + make + " " + model + "\n\tPrice : " + price;
    }

}
