 
package iar1905190p2_easyrent;
 
public class Airline {
  
 private String twoDigitCode;
 private String name;    
 private String originCountry;   
 private String website;    
 
 public Airline(String twoDigitCode,String name,String originCountry,String website){
 
   this.twoDigitCode = twoDigitCode;
   this.name = name;
   this.originCountry = originCountry;
   this.website = website;

 }
    
   //setter method 
    public void setTwoDigitCode(String twoDigitCode){
   this.twoDigitCode = twoDigitCode;
    } 
 public void setName(String name){
   this.name = name;
    } 
  
 public void setOriginCountry(String originCountry){
   this.originCountry = originCountry;
    } 
 
 public void setWebsite(String website){
    this.website = website;
    } 
//getter methods
   public String getTwoDigitCode(){
    return twoDigitCode;
    }
    
    
    public String getName(){
    return name;
    }
    
    public String getOriginCountry(){
    return originCountry;
    }
    
     
    public String getWebsite(){
    return website;
    }
    
    public String toString(){
    return "	Airline No.: "+this.twoDigitCode+"	Airline: "+this.name+"	Hub: "+this.originCountry+"	URL: "+this.website;
    }

}
