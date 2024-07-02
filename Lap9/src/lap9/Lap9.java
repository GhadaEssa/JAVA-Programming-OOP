
import java.util.*;
import lap9.Items;

 
 
public class Lap9 {
 
    public static void main(String[] args) {
         String shoppingCon="y";
         double total=0;
         Items newItem;
         Scanner input=new Scanner(System.in);
         Scanner forNextLine=new Scanner(System.in);
        
       ArrayList<Items> itemsPurchased = new ArrayList<>();
         
        do{
        System.out.print("Enter the name of the Item: "); 
        String name=forNextLine.nextLine() ;
         
             
        System.out.print("Enter the unit price: ");
        double price=input.nextDouble();
        
        System.out.print("Enter the quantity: ");
        int quantity=input.nextInt();
             
       newItem=new Items(name,price,quantity); 
       itemsPurchased.add(newItem);
       
        System.out.print("Continue shopping(y/n): ");
        shoppingCon=input.next(); 
     
        
        
        }while( shoppingCon.equalsIgnoreCase("Y"));
        
        
        System.out.println("\nFinal Shopping Cart Totals");
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("ItemName"+"\t  "+"Unit price"+"\t  "+"Quantity"+"\t  "+"price * quantity");
        
        for (int i = 0; i < itemsPurchased.size(); i++) {
            
            System.out.println(itemsPurchased.get(i).toString()); 
            total+=itemsPurchased.get(i).getPrice()*itemsPurchased.get(i).getQuantity(); 
    }
        System.out.println("Total amount in the cart "+total+" SAR");


    
      
    
    }

}