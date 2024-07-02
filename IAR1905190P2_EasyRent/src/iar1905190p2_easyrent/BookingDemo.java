 
package iar1905190p2_easyrent;
 
 
import java.io.*;
import java.text.*;
 import java.util.*;
 

public class BookingDemo {
 
   public static void main(String[] args) throws Exception {
           
    /*
         Student Name: Ghada Essa Alsulami 
         ID:1905190 
         Section Number:14313
         */
       
       
       
    // creating the input file to read the data of the air tickets  
     File inputDB=new File("inputDB.txt");
    
     
     // check if the file exists
     if (!(inputDB.exists())) {
            System.out.println("The file '" + inputDB.getName() + "' doesn't exist.");
            System.exit(0);
        }
    
        //once the file is already exist you can take the information frome it.
        Scanner  read1 =new Scanner(inputDB); 
       
        //create a 1D arrays and read their size frome the file.
        Airline[] airline = new Airline[read1.nextInt()];//6
        Airport[] airport = new Airport[read1.nextInt()];//9
        Flight[] flight = new Flight[read1.nextInt()];//9
        
        
         
        // I assigned the value 0 to each variable to be use as an index for the arrays.
        int sizeFlight=0;
        int sizeAirline=0;
        int sizeAirpot=0;
        String comand;//To read the commands in the file inputDB.txt
        do {

            comand = read1.next();

            if (comand.equalsIgnoreCase("ADD_Airline")) { 
                airline[sizeAirline]=getAirline(read1); 
                sizeAirline++;// increasing the index after the command is finished.
            } else if (comand.equalsIgnoreCase("ADD_Flight")) {
                flight[sizeFlight]=getFlight(read1);sizeFlight++;
            } else if (comand.equalsIgnoreCase("ADD_Airport")) {
                   airport[sizeAirpot]=getAirport(read1);sizeAirpot++;
            }

        } while (!comand.equalsIgnoreCase("Quit"));
         
         // To create a file to use it for the print air tickets file. 
        File printLog=new File("printLog.txt");
        //To write the information in the printLog.txt file;
        PrintWriter output1=new PrintWriter(printLog);
        output1.println("--------------- Air Ticket Reservation System Log ---------------\n\n");


        //Print the whole information(in the method)
         PrintSystemLog( airline, flight,  airport, output1);
    
        read1.close();
        output1.flush(); 
        output1.close();
       
        //[The first file accomplished] 
        
        
        
         
        File inputBookings=new File("inputBookings.txt"); 
        Scanner  read2 =new Scanner(inputBookings);//to read the data from "inputBookings.txt" file
        
        Booking[] booking = new Booking[read2.nextInt()];//13
        
       File printBookings = new File("printBookings.txt");
       PrintWriter output2 = new PrintWriter(printBookings);
      
       output2.print("--------------- Welcome to Air Ticket Reservation System ---------------\n\n");
       String comand2;
       int bookinSize = 0;
       do {

           comand2 = read2.next();

           if (comand2.equalsIgnoreCase("NewBooking")) {
               booking[bookinSize] =GenerateBooking(read2, flight, airline, airport);//return an object from the method
               PrintBooking(booking[bookinSize],output2);
               bookinSize++;//increasing index after each iteration
           }

       } while (!comand2.equalsIgnoreCase("Quit"));

        
         

       output2.flush();
       read2.close();
       output2.close();

    //[The Second file accomplished] 
   
   
   
   }// The main class
    
   
   
   
   
   //ADD_Airline method to return an object with the specific iformation-------------------------------------
   
  private  static Airline getAirline(Scanner read) {

        String twoDigitCode = read.next();
        String airlineName = read.next();
        String originCountry = read.next();
        String website = read.next();

        return  new Airline(twoDigitCode, airlineName, originCountry, website);

    }

   //ADD_Airport method to return an object with the specific iformation-------------------------------------
    
    private  static Airport getAirport(Scanner read) {

        String threeDigitCode = read.next();
        String city = read.next();
        String name = read.next();

        return new Airport(threeDigitCode, city, name);

    }
    
    //ADD_Flight method to return an object with the specific iformation--------------------------------------
    
    private  static Flight getFlight(Scanner read) {

        String flightNo = read.next();
        String departure = read.next();
        String destination = read.next();
        double fare = read.nextDouble();

        return new Flight(flightNo, departure, destination, fare);

    }
    
    //PrintSystemLog is using to print the first file printLog.txt
  //----------------------------------------------------------------
    public static void PrintSystemLog(Airline[] airline, Flight[] flight, Airport[] airport, PrintWriter output1) {

        for (int i = 0; i < airline.length; i++) {

            output1.println("\n(New Airline Added)" + airline[i].toString()
                    + "\n-------------------");

        }

        for (int i = 0; i < flight.length; i++) {

            output1.println("\n(New Flight Added)" + flight[i].toString()
                    + "\n-------------------");

        }
        for (int i = 0; i < airport.length; i++) {

            output1.println("\n(New Airport Added)" + airport[i].toString()
                    + "\n-------------------");

        }

    }

    
//---------------------------------------------------------------------------------------------------------------------
     private  static Booking  GenerateBooking(Scanner read, Flight[] flight,Airline[] airline ,Airport[] airport) throws ParseException  {

        
         
         
         long bookingNo = System.currentTimeMillis();
        String flightNumber = read.next();
        String Two_letterAirlineCode = read.next();
        String Three_letterCityCode = read.next();
        
        String DateFormat1=read.next()+"-"+read.next()+"-"+read.next();
        //I used this class to convert the string date to date type
        SimpleDateFormat SimpleDate1 = new SimpleDateFormat("yyyy-d-m"); 
        Date dateOfTravel =SimpleDate1.parse(DateFormat1) ;
        
        String nameOfPassenger= read.next();
        
         String DateFormat2=read.next()+"-"+read.next()+"-"+read.next(); 
         SimpleDateFormat SimpleDate2 = new SimpleDateFormat("yyyy-d-m");
         Date DateOfBirthOfPassenger=SimpleDate2.parse(DateFormat2);
         
           
         boolean businessClass=read.nextBoolean();
         int baggageWeight=read.nextInt();
         
         //return the index of the specific object from flightNumberSearch,AirlineObjectSearch,and AirportObjectSearch methods
         int flightObject=flightNumberSearch(flightNumber,flight); 
         int airlineObject=AirlineObjectSearch(Two_letterAirlineCode,airline);
         int airportObject=AirportObjectSearch(Three_letterCityCode,airport);
         
         
         return new Booking(bookingNo,flight[flightObject],airline[airlineObject],airport[airportObject], dateOfTravel, nameOfPassenger, DateOfBirthOfPassenger,businessClass, baggageWeight);

        

    } 
    
    
//------------------------------------------------------------------------------------------------------  
 public static int flightNumberSearch(String s,Flight[] flight){
      
        int objectNumber = 0;
        for (int i = 0; i < flight.length; i++) {

            if (s.equalsIgnoreCase(flight[i].getFlightNo())) {
                objectNumber = i;
            }

        }
return objectNumber;
    
    }
 
 //------------------------------------------------------------------------------------------------------  
    public static int AirlineObjectSearch(String s, Airline[] airline) {

        int objectNumber = 0;
        for (int i = 0; i < airline.length; i++) {

            if (s.equalsIgnoreCase(airline[i].getTwoDigitCode())) {
                objectNumber = i;
            }

        }
        return objectNumber;

    }
//-------------------------------------------------------------------------------------------------------
    public static int AirportObjectSearch(String s, Airport[] airport) {

        int objectNumber = 0;
        for (int i = 0; i < airport.length; i++) {

            if (s.equalsIgnoreCase(airport[i].getThreeDigitCode())) {
                objectNumber = i;
            }

        }
        return objectNumber;

    }

  //------------------------------------------------------------------------------------------------------  
    public static void PrintBooking(Booking tempBooking, PrintWriter output2) {

        Date dateOfBirth = tempBooking.getDob();
        SimpleDateFormat SimpleDate1 = new SimpleDateFormat("yyyy-m-d");
        String dateOfBirthInStr = SimpleDate1.format(dateOfBirth);

        Date dateOfTravel = tempBooking.getFlightDate();
        SimpleDateFormat SimpleDate2 = new SimpleDateFormat("yyyy-m-d");
        String dateOfTravelInStr = SimpleDate2.format(dateOfTravel);

        output2.printf("\nBooking No. %d\n", tempBooking.getBookingNo());
        output2.printf("\nPassenger Details	Passenger Name: %s		Date of Birth: %s\n", tempBooking.getName(), dateOfBirthInStr);

        output2.printf("\nFlight Details	Flight Code: %s-%s			%s\n", tempBooking.getAirline().getTwoDigitCode(), tempBooking.getFlight().getFlightNo(), dateOfTravelInStr);
        output2.printf("		Departure: %s			Destination: %s\n", tempBooking.getFlight().getDeparture(), tempBooking.getFlight().getDestination());

        output2.printf("\nAirport Details	tAirport Name: %s (%s), %s\n", tempBooking.getAirport().getName(), tempBooking.getAirport().getThreeDigitCode(), tempBooking.getAirport().getCity());
        output2.printf("\nAirline Details	Name: %s based in %s\n", tempBooking.getAirline().getName(), tempBooking.getAirline().getWebsite());

        output2.printf("\nFare Details	Regular Fare: SAR %.1f\n", tempBooking.getFlight().getFare());
        output2.printf("		Total Fare: SAR %.1f\n", tempBooking.getTotalFare());
        output2.print("â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€");
    }



//----------------------------------------------------------------------------------------------------------
 public static void NumOfFlightsPerAirport(Airport[] allAirports, Booking[] allTickets,PrintWriter fWrite) {}






}
    

