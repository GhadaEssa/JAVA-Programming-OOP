 
package lap4;
 
public class Rectangle {

double width=1;
double height=1;


  Rectangle() {
  
  
  }  
    
    
   Rectangle(double newWidth,double newHeight) {
  
  width=newWidth;
  height=newHeight;
  }   
    
 public void setWidth(double newWidth) {
       width=newWidth;
    }   
    
  public void setHeight(double newHeight) {
      height= newHeight;
    }     
    
    
   public double getHeight() {
      return height;
    }     
   
   
   public double getWidth() {
      return  width;
    }       
   
   
   
  public double getArea() {
      return  width*height;
    }         
   
   
   public double gePerimeter() {
      return  (width+height)*2;
    }        
   
   
   public String toString() {
       
       String Infor ="width= " + getWidth()
               + "\nHeight= " + getHeight()
               + "\nArea= " + getArea()
               + "\nPerimeter= "+ gePerimeter()
               +"\n";
    return Infor;
   }        
   
   
}
