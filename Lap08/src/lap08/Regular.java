 
package lap08;

public class Regular extends Customer {
    // define discountRate=0.05 as constant
    private final double discountRate=0.05;
    //-------------------------------------
    public Regular()
    {
        
    }
    //--------------------------------------
    public Regular(String name,double purchasesCost)
    {
        super(name,purchasesCost);
    }
    //---------------------------------------
    //override getPurchasesCost as requested
    public double getPurchasesCost()
    {
        return (super.getPurchasesCost()-(super.getPurchasesCost()*discountRate));
    }
    //---------------------------------------
    //override toString()as requested
    public String toString()
    {
    return super.toString()+", cost after discount= "+getPurchasesCost();
    }
}
