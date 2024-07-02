package iar1905190p3_easyrent;

import java.io.*;
import java.util.*;

public class IAR1905190P3_EasyRent {

    public static void main(String[] args) throws Exception {

       
        /* 
        Section: IAR
        Section Number:14313
        Student Name: Ghada Essa Alsulami 
        ID:1905190 
         */
       
        
        
        File inputFile = new File("input.txt");

        // check if the file exists
        if (!(inputFile.exists())) {
            System.out.println("The file '" + inputFile.getName() + "' doesn't exist.");
            System.exit(0);
        }

        //once the file is already exist you can take the information frome it.
        Scanner read = new Scanner(inputFile);

        Vehicle[] vehicles = new Vehicle[read.nextInt()];
        Customer[] customers = new Customer[read.nextInt()];

        File printFile = new File("output.txt");
        PrintWriter output = new PrintWriter(printFile);
        output.println("--------------- Welcome to X Vehicle store System ---------------");

          
          
        int vehicleIndex = 0;//current vehicle
        int customerSize = 0;//current customer
        String comand = "";//To read the commands in the file 'input.txt'
        do {

            comand = read.next();

            if (comand.equalsIgnoreCase("Add_Customer_Record")) {
                if (customerSize < customers.length) {//check if the array arrived to the maximum No.of  customers
                    customers[customerSize] = Add_Customer_Record(read);
                    printCustomers(output, customers[customerSize]);
                    customerSize++;
                    
                }
            } else if (comand.equalsIgnoreCase("Add_Rental")) {
                if (vehicleIndex < vehicles.length) {//check if the array arrived to the maximum No.of vehicles
                    vehicles[vehicleIndex] = Add_Rental(read);
                    printVehicles(output, vehicles[vehicleIndex]);
                    vehicleIndex++;
                    
                }

            } else if (comand.equalsIgnoreCase("Add_Sale")) {
                if (vehicleIndex < vehicles.length) {//check if the array arrived to the maximum No.of vehicles
                    vehicles[vehicleIndex] = Add_Sale(read);
                    printVehicles(output, vehicles[vehicleIndex]);
                    vehicleIndex++;
                    
                }

            } else if (comand.equalsIgnoreCase("Ass_Customer_to_Rent")) {

                Ass_Customer_to_Rent(read, customers, vehicles, output);

            } else if (comand.equalsIgnoreCase("Print_Rental")) {
                Print_Rental(vehicles, output,vehicleIndex);
            } else if (comand.equalsIgnoreCase("Print_Sale")) {
                Print_Sale(vehicles, output);
            }

        } while (!comand.equalsIgnoreCase("Quit"));

        output.print("\n\n\nThank you for using X Store Vehicle System, Good Bye!");
        read.close();
        output.flush();
        output.close();

    } //main

    //-------------------------------------------------------------------------------------------------------   
    public static Customer Add_Customer_Record(Scanner input) {

        int id = input.nextInt();
        String name = input.next();
        String nationality = input.next();
        char gender = input.next().charAt(0);
        int phone = input.nextInt();
        return new Customer(id, name, nationality, gender, phone);

    }

    //-------------------------------------------------------------------------------------------------------   
    public static Rental Add_Rental(Scanner input) {

        String license = input.next();
        String make = input.next();
        String model = input.next();
        double price = input.nextDouble();
        double rentPerDay = input.nextDouble();
        int maxNumberOfRenters = input.nextInt();

        return new Rental(rentPerDay, maxNumberOfRenters, license, make, model, price);

    }

   //-------------------------------------------------------------------------------------------------------   
    public static Sale Add_Sale(Scanner input) {

        String license = input.next();
        String make = input.next();
        String model = input.next();
        double price = input.nextDouble();
        double discountRate = input.nextDouble();

        return new Sale(discountRate, license, make, model, price);

    }
   //-------------------------------------------------------------------------------------------------------   

    public static void printCustomers(PrintWriter output, Customer customers) {

        output.println("\nCommand Add_Customer:");
        output.println("Add a new Customer record in the System");

        output.println(customers.toString());
        output.print("\n-------------------------------------------------------------------------------\n");
    }
//-------------------------------------------------------------------------------------------------------   

    public static void printVehicles(PrintWriter output, Vehicle vehicles) {

        if (vehicles instanceof Rental) {
            output.println("Command Add_Rental: Add a new vehicles for rent in the System");
            output.print(vehicles.toString());
        } else if (vehicles instanceof Sale) {
            output.println("Command Add_Sale: Add a new new vehicles for sale in the System");
            output.print(vehicles.toString());
        }

        output.print("\n----------------------------------------------------------------\n");
    }

//-------------------------------------------------------------------------------------------------------   
    public static void Ass_Customer_to_Rent(Scanner input, Customer[] customers, Vehicle[] vehicles, PrintWriter output) {
        output.println("Command Ass_Customer_to_Rent: A  Customer rent a vehicle ");

        String license = input.next();
        int customerID = input.nextInt();
        int numOfDays = input.nextInt();
        int vehicleObj = licenseNumberSearching(vehicles, license);   
        int customerObj = customerIDSearching(customers, customerID); 
        if (vehicleObj == -1) {
            output.println("Vehicle Not found: " + license);

        }
        if (customerObj == -1) {
            output.println("Customer Not found: " + customerID);

        }

        if (customerObj != -1 && vehicleObj != -1) {
            if (vehicles[vehicleObj] instanceof Rental) {

                if (((Rental) vehicles[vehicleObj]).getCurrentCustomerNo() < ((Rental) vehicles[vehicleObj]).getRentedTo().length) {
                    output.println("\nCustomer: " + customerID + " Rents Vehicle : 	" + license);
                    ((Rental) vehicles[vehicleObj]).addCustomer(customers[customerObj], numOfDays);

                } else {
                    output.println("This vehicle reaches the max number of rent: " + license);
                }

            }
        }

        output.println("-------------------------------------------------------------------------------");

    }
//-------------------------------------------------------------------------------------------------------   

    public static int licenseNumberSearching(Vehicle[] vehicles, String license) {

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Rental) {

                if (vehicles[i].license_number.equalsIgnoreCase(license)) {
                    return i;
                }

            }

        }
        return -1;
    }

//-------------------------------------------------------------------------------------------------------   
    public static int customerIDSearching(Customer[] customers, int customerID) {

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] instanceof Customer) {

                if (customers[i].getId() == customerID) {
                    return i;
                }

            }
        }

        return -1;
    }
//-------------------------------------------------------------------------------------------------------   
    public static void Print_Rental(Vehicle[] vehicles, PrintWriter output, int vehiclesCapacity) {
        output.println("\nCommand: Print_Rental\n\n\n"
                + "==================================================================");
       
        Arrays.sort(vehicles, 0, vehiclesCapacity);//to arrange the array objets depending on a licence vehicles

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Rental) {
                //return customer array in particular vehicle object
                Customer[] renters = ((Rental) vehicles[i]).getRentedTo();
               
                /**the statement checks weather the current customer still at index 0 because 
                 * if there, this means there is no customer has rented the vehicle yet*/ 
                if (((Rental) vehicles[i]).currentCustomerNo != 0) {
                    output.println(vehicles[i].toString());
                    output.println("------------\n"
                            + "");
                    output.println("\tRented to:\n "
                            + " ");
                    for (int j = 0; j < renters.length; j++) {
                        int num = j + 1;

                        if (renters[j] instanceof Customer) {

                            output.printf("\tCustomer # %d	ID: %s	Number of Days: %d	Price: %.1f\n", num, renters[j].getId(), renters[j].getRental_days(), ((Rental) vehicles[i]).CalcPrice());

                        }

                    }

                } else {
                    output.println("\n" + vehicles[i].toString());
                    output.println("------------\n"
                            + "");
                    output.println("\tRented to: "
                            + " ");
                    output.println("\tNo body");

                }

                output.print("-------------------------------------------------------------------------------");
            }

        }

    }
    //-------------------------------------------------------------------------------------------------------   

    public static void Print_Sale(Vehicle[] vehicles, PrintWriter output) {
        output.println("\n\n\nCommand: Print_Sale\n"
                + "\n"
                + "\n"
                + "=================================================================="
                + "	");

         
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Sale) {

                output.println(vehicles[i].toString());
                output.print("----------------------------------------------------------------");

            }

        }

    }
}
