 
package lap9;
 
public class Items {
   
private String name;
private double price;
private int quantity;

public Items( String itemName, double itemPrice, int numPurchased ){
name = itemName;
price = itemPrice;
quantity = numPurchased;
}
public String getName(){
return name;
}
public void setName(String itemName){
  name = itemName;  
}
public double getPrice(){
return price;
}
public void setPrice(double itemPrice){
  price = itemPrice; 
}
public int getQuantity(){
return quantity;
}
public void setQuantity(int numPurchased){
  quantity = numPurchased;
}
@Override
public String toString(){
 
    return String.format("%-8s\t%5.1f\t%11d\t%14.1f",name , price , quantity ,(price * quantity));
}
}
  
 
