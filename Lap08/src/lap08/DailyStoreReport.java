
package lap08;
 
import java.util.Scanner;

public class DailyStoreReport {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of customers for the current day:");

        Customer[] customers = new Customer[5];
        customers[0] = new New("8",8);
        customers[1] = new VIP("8",8);
        customers[3] = new New("8",8);
        
        for (int i = 0; i < 5; i++) {
         if( customers[i] instanceof New){System.out.println("New");}   
        }
        
        
        
        
        
    }
    
    
  public static void enterInfo(Customer[] customers, Scanner input ){
      System.out.println("--------------------------------------------------------------------");
      for (int i = 0; i < customers.length; i++) {
           
          
      System.out.println("--------------------------------------------------------------------");
      }
 
  
  }  
}
    

    
    
    
    
 
