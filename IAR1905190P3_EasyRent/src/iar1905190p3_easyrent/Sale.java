
package iar1905190p3_easyrent;


public class Sale extends Vehicle{
    private double sell_price;
    private double discount;
    private double rate;
    
     //-------------------------------------------------------------------------
    public Sale(double rate, String license_number, String make, String model, double price) {
        super(license_number, make, model, price);
        this.rate = rate;

    }
    //-------------------------------------------------------------------------
    @Override
    public String getLicense_number() {
        return super.license_number;
    }
    //-------------------------------------------------------------------------
    @Override
    public double CalcPrice() {

        discount = ((rate / 100.0) * super.price);
        sell_price = super.price - discount;

        return sell_price;
    }

    //-------------------------------------------------------------------------
    @Override
    public int compareTo(Vehicle t) {
        return super.license_number.compareTo(t.license_number);
    }
    //-------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "\n\tDiscount rate	:" + rate + " % \n"
                + "\tSelling Price 	:" + CalcPrice();
    }

}
