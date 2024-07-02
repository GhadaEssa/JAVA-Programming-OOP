 
package lap03;

import java.util.*;
 
public class Lap03 {
 
    public static void main(String[] args) {

        //Ghada Essa-1905190-IAR
        
        Scanner input = new Scanner(System.in);

        System.out.println("Course ID Generator:\n"
                + "---------------------------------- ");
        System.out.println("Please Enter Course Information ");
        
        //Q1
        System.out.print("Course Code(only capital letters with a length between 2 and 4): ");
        String courseCode = input.next();
        boolean isCapitalLen=!(courseCode.matches("[A-Z]+"))||!(courseCode.length()>=2&&courseCode.length()<=4);
        while(isCapitalLen){
            if(!(courseCode.length()>=2&&courseCode.length()<=4)){
        System.out.println("Course Code length was not between 2 and 4 , Please try again ");
            }
            else{
            System.out.println("Course Code must only have capital letters , Please try again");
            }
            
        System.out.print("Course Code(only capital letters with a length between 2 and 4): ");
        courseCode = input.next();
        isCapitalLen=!(courseCode.matches("[A-Z]+"))||!(courseCode.length()>=2&&courseCode.length()<=4);
         
        }
        
        //Q2
        System.out.print("Course Number(consist only of 3 digits):");
        String digit=input.next();
        boolean isThreeDigit= !(digit.matches("\\d\\d\\d"));
        
        while(isThreeDigit){
        System.out.println("Course Number length was not 3 , Please try again");
        System.out.print("Course Number(consist only of 3 digits):");
        digit=input.next();
        isThreeDigit= !(digit.matches("\\d\\d\\d"));
         
        }
       
        //Q3
        System.out.print("Year:");
        int year=input.nextInt();
        
        //Q4
        System.out.print("Semester(Fall=01,Sprint=02,Summer=03):");
        int semester=input.nextInt();
        
        while(!(semester==1||semester==2||semester==3)){
        System.out.println("Please enter correct semester code, try again");
        System.out.print("Semester (Fall=01, Sprint=02, Summer=03): ");
        semester=input.nextInt();
        }
        
        //Q5
        System.out.print("Course Reference Number:");
        int referenceNumber=input.nextInt();
        
        System.out.print("----------------------------------\n"
                + "Generated Course ID: ");// CPCS203-201902-12345

        StringBuilder ID=new StringBuilder(courseCode);
        ID.append(digit);
        ID.append("-");
        ID.append(year);
        ID.append("0");
        ID.append(semester);
        ID.append("-");
        ID.append(referenceNumber);
       System.out.println(ID); 
    
    }

}
