
package iar1905190p2_easyrent;
 
public class Booking {

 private long bookingNo;
 private Flight  flight;    
 private Airline airline;   
 private Airport airport; 
 java.util.Date flightDate;
 private String name;  
 private java.util.Date dob;   
 boolean isBusinessClass; 
 private int baggageWeight;

 public Booking(long bookingNo, Flight flight, Airline airline, Airport airport, java.util.Date flightDate, String name, java.util.Date dob, Boolean isBusinessClass, int baggageWeight){
 
     this.bookingNo = bookingNo;
     this.flight = flight;
     this.airline = airline;
     this.airport = airport;
     this.flightDate = flightDate;
     this.name = name;
     this.dob =dob;
     this.isBusinessClass = isBusinessClass;
     this.baggageWeight= baggageWeight;
     
     
 }
 
//setter(9)
 

 public void setBookingNo(long bookingNo){
 
 this.bookingNo=bookingNo;
 }


public void setFlight(Flight flight){
 
 this.flight=flight;
 }

public void setAirline(Airline airline){
 
 this.airline = airline;
 }



public void setAirport(Airport airport){
 
 this.airport = airport;
 }


public void setFlightDate(java.util.Date flightDate){
 
 this.flightDate =flightDate;
 }


public void setName(String name){
 
 this.name=name;
 }

public void setDob(java.util.Date dob){
 this.dob = dob;
 }

public void setIsBusinessClass(boolean isBusinessClass){
 this. isBusinessClass = isBusinessClass;
 }

public void setBaggageWeight(int baggageWeight){
 this.  baggageWeight=  baggageWeight;
 }


//getter method
 public long getBookingNo(){
 
 return bookingNo;
 }
 
 public Flight getFlight(){
 
 return flight;
 }
 
 public Airline getAirline(){
 
 return airline;
 }
 
 
 public Airport getAirport(){
 
 return airport;
 }
 
 public java.util.Date getFlightDate(){
 
 return flightDate;
 }
 public String getName(){
 
 return name;
 }
 
 public java.util.Date getDob(){
 
 return dob;
 }
 
 public Boolean getIsBusinessClass(){
 
 return isBusinessClass;
 }
 
 
 
 public int getBaggageWeight(){
 
 return baggageWeight;
 }

 public double getTotalFare(){
 
 int age= flightDate.getYear()-dob.getYear();
 double TotalFare=0;     
 double RegulareFare=flight.getFare();
  
 if(age<=12&&age>2){
 RegulareFare*=(70/100.0);
  
 }
 else if(age<=2){
 
  RegulareFare*=(10/100.0);
   
 }
        
   
        
  if(isBusinessClass){
 RegulareFare*=1.4;
 if(baggageWeight>50){
 int extraBaggageWeight=baggageWeight-50;
 TotalFare=RegulareFare+(extraBaggageWeight*30);
 
 }
 else{TotalFare=RegulareFare;}
 }
 
else{
 
 if(baggageWeight>30){
 int extraBaggageWeight=baggageWeight-30;
 TotalFare=RegulareFare+(extraBaggageWeight*30);
  
 }
 else{TotalFare=RegulareFare;}
 
 }  
      
     return TotalFare;
 
  
 
}
    
     
 
 
}
