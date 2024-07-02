 
package lap08;
 

public class VIP extends Customer {
    // define discountRate=0.1 as constant
    private final double discountRate=0.1;
    // define and initialize GiftCertivacateValue with zero
     private double GiftCertivacateValue=0;
    
     //-------------------------------------
    public VIP()
    {
        
    }
    //--------------------------------------
    public VIP(String name,double purchasesCost)
    {
        super(name,purchasesCost);
    }
    //---------------------------------------
    //add GiftCertivacate()that check if the PurchasesCost exceed 1000,
    //then a 100 will be added to GiftCertivacateValue and returned
    public double GiftCertivacate(){
    
        if(super.getPurchasesCost()>1000){
        
            System.out.println("Congratulation for the next customer. You Won 100.0 SR. gift certificate");
            
        
        }
  return   GiftCertivacateValue+=100;
    }
    
    
    
    //---------------------------------------
    //override getPurchasesCost as requested
    @Override
    public double getPurchasesCost()
    {
        return (super.getPurchasesCost()-(super.getPurchasesCost()*discountRate)); 
    }
    //---------------------------------------
    //override toString()as requested
    @Override
    public String toString()
    {
    return "VIP"+super.toString()+", cost after discount= "+getPurchasesCost();
    }
}
