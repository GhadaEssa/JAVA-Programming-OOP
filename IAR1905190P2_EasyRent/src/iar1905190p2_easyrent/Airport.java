 
package iar1905190p2_easyrent;
 
public class Airport {
     
    
private String threeDigitCode;    
private String city;    
private String name;    
    
  public Airport(String threeDigitCode,String city,String name){
  
  this.threeDigitCode=threeDigitCode;
  this.city=city;
  this.name=name;
  
  }  
    
   //getter methods
  
    public String getThreeDigitCode(){
    return threeDigitCode;
    }
    
   public String getCity(){
    return city;
    } 
    
    
   public String getName(){
    return name;
    } 
    
   //setter method
    
    public void setThreeDigitCode(String threeDigitCode){
    this.threeDigitCode=threeDigitCode;
    }
    
    public void setCity(String city){
    this.city=city;
    }
    
    
    public void setName(String name){
    this.name=name;
    }
    
    
    public String toString(){
    return "	Airport Code: "+this.threeDigitCode+"	City: "+this.city+"	Name: "+this.name;
    }
  
    
}

