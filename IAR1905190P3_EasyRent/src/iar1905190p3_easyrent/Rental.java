 
package iar1905190p3_easyrent;
 
public class Rental extends Vehicle {
    
    protected double rate_per_day;
    protected Customer[] rentedTo;
    protected int currentCustomerNo;
    private int index;
    //-------------------------------------------------------------------------

    public Rental(double rate_per_day, int max, String license_number, String make, String model, double price) {
        super(license_number, make, model, price);
        this.rate_per_day = rate_per_day;
        this.rentedTo = new Customer[max];

    }

    //-------------------------------------------------------------------------
    public void addCustomer(Customer customer, int numOfDays) {

        rentedTo[currentCustomerNo] = customer;
        rentedTo[currentCustomerNo].setRental_days(numOfDays);
        currentCustomerNo++;
    }

    //-------------------------------------------------------------------------
    public Customer[] getRentedTo() {
        return rentedTo;
    }

    //-------------------------------------------------------------------------
    public int getCurrentCustomerNo() {
        return currentCustomerNo;
    }

    //-------------------------------------------------------------------------
    @Override
    public String getLicense_number() {

        return super.license_number;
    }

    //-------------------------------------------------------------------------
    @Override
    public double CalcPrice() {

        /**
         * I defined the variable 'index' with data field to be as a counter
         * increases each time.
         */
        return rentedTo[index++].getRental_days() * rate_per_day;
    }

    //-------------------------------------------------------------------------
    @Override
    public int compareTo(Vehicle t) {
        return super.license_number.compareTo(t.license_number);
    }

    //-------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "	Rate per day: " + rate_per_day;
    }

}
