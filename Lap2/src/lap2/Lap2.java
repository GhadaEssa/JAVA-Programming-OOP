 
package lap2;

import java.util.Scanner;
 
public class Lap2 {
 
    public static void main(String[] args) {
        
         //Ghada Essa Alsulami-1905190
        
        Scanner input=new Scanner(System.in);
         
         System.out.println("Enter a string for Email: ");
        
         System.out.println("** Please enter at least 6 characters contain at least 1 digit ! ");
         String str=input.next();
        
         if(isValidEmail(str)){
                  //الفكرة هنا إن اذا كان الايميل حقق الشروط اخزن في متغير من نوع سترنج بيلدر عشان اقدر استخدم الميثود ابند 
                  StringBuilder email = new StringBuilder(str);
                  System.out.println("** valid Email **");
                 // append method
                  System.out.println("Your email adress is: "+email.append("@kau.edu.sa")); }
        
     else{
        
        System.out.println("** Invalid Email **");
        }
    }
   
    public static boolean isValidEmail(String str) { 
        
        if (str.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*")&&str.length() >= 6) {
                  
          return true;         
                
        }
        
           
        
  
return false;
    }
}
