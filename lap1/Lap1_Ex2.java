 
package lap1;
 
import java.util.Scanner;

public class Lap1_Ex2 {

    public static void main(String[] args) {
    int point1=0,point2=1; 
     Scanner input=new Scanner(System.in);
        
        System.out.print("Enter the number of points: ");
         int numberOfPoints=input.nextInt();
        
         double[][] points=new double[numberOfPoints][2];
         
         System.out.print("Enter "+numberOfPoints+" points: ");
         
         for(int i=0;i<points.length;i++){
         points[i][0]=input.nextDouble();
         points[i][1]=input.nextDouble();
         }
   
         FindClosetTwoPoints(point1,point2,points);
    }
    
    
    public static void FindClosetTwoPoints(int point1, int point2, double[][] points) {

         
        double distance;
        double shortestDistance = Distance(points[point1][0], points[point1][1], points[point2][0], points[point2][1]);

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distance = Distance(points[i][0], points[i][1], points[j][0], points[j][1]);

                if (shortestDistance > distance) {
                   point1 = i;
                    point2 = j;
                    shortestDistance = distance;
                }
            }
        }
           
        
        System.out.println("The closest two points are ("+points[point1][0]+","+points[point1][1]+")" + " and ("+points[point2][0] +","+points[point2][1]+")");

    }
    
    public static double Distance(double x1,double y1,double x2,double y2){
    
    return Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));

    }
    

}
    

 
