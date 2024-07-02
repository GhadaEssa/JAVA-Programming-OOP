 
package iar1905190p2_easyrent;
 
public class Flight {
    
    
    private String flightNo;
    private String departure;
    private String destination;
    private double fare;   
    
    public Flight(String flightNo,String departure,String destination,double fare){
 
   this.flightNo = flightNo;
   this.departure = departure;
   this.destination = destination;
   this.fare= fare;

 }
    
    //setter method 
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
    
    //GETTER MWTHOD
     public String getFlightNo(){
    return flightNo;
    }
    
    
    public String getDeparture(){
    return departure;
    }
    
    public String getDestination(){
    return destination;
    }
    
     
    public double getFare(){
    return fare;
    }
    
    
    public String toString(){
    return "	Flight No: "+this.flightNo+"	Departure: "+this.departure+"	Destination: "+this.destination+"	Fare: SAR "+this.fare;
    }
    
}
