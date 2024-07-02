 
package lap10;
 
public class Bus  extends BasicVehicle {

  private String driverName;
    Bus(int noOfWheels,int noOfSeats , int noOfDoors, String type, String driverName){
            super( noOfWheels, noOfSeats ,  noOfDoors,  type);
            this.driverName=driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n Driver: "+ driverName;
    }
    
 
 
 
 
 
}
