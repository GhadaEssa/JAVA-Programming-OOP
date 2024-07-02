 
package lap10;
 
public abstract class BasicVehicle implements Vehicle{
 
 private int numOfWheels=0;
 private int numOfSeats=0;
 private int numOfDoors=0;
 private String type="";

    public BasicVehicle(int numOfWheels, int numOfSeats, int numOfDoors, String type) {
        this.numOfWheels =numOfWheels;
        this.numOfSeats= numOfSeats;
        this.numOfDoors = numOfDoors;
        this.type = type;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public int getNumOfWheels() {
        return numOfWheels ;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public String  getVehicleType() {
        return type;
    }

    
    
    
    
    
    
    @Override
    public String toString() {
        return  " Type: " + type+"\n # Of Wheels=" + numOfWheels + "\n # of Seats=" + numOfSeats + "\n # of Doors=" + numOfDoors ;
    }
 
 
    
}
