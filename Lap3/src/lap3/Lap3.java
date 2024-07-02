 
package lap3;

import java.io.*;
import java.util.*;
 
public class Lap3 {
 
    public static void main(String[] args) throws   Exception{
//         File file1 = new File("file1.txt");
//        File file2 = new File("file2.txt");
//        File file3 = new File("file2.txt");
//         
//
//        PrintWriter output2;
//        Scanner input2;
//         Scanner input1;
//            
//            output2 = new PrintWriter(file2);
//            input2 = new Scanner(file3);
//            input1 = new Scanner(file1);
//            
//            if(!file1.exists()){
//                System.out.println("The file does not exist.");
//                System.exit(0);
//            }
//            
//            else{
//                System.out.println("The file exists.");
//            }
//            while (input1.hasNext()) {
//                 
//                String text = input1.nextLine();
//                String text2 = text.replaceAll("[a-zA-z\\W]"," ");
//              
// output2.print(text2);
//            }
//            input1.close();
//            output2.flush();
//        
//   
//   System.out.print("The prime numbers are: ");
//    while (input2.hasNext()) {
//
//            int  number= input2.nextInt();
//            
//            for (int i = 2; i < number; i++) {
//                if (number % i == 0) {
//                    number = input2.nextInt();
//                    i = 1;
//                }
//
//            }
//    System.out.print(number+" ");
//        }
//input2.close();
//output2.close();

    
    
  File file1=new File("file1.txt");  
   
  if(!file1.exists()){
      System.out.println("The file doesn't exist.");
      System.exit(0);
  }
    
   else{
               System.out.println("The file exists.");
           }  
    
    Scanner inputFromFile1=new Scanner(file1);
    
    PrintWriter output=new PrintWriter(new File("output.txt"));
    
    while(inputFromFile1.hasNext()){
   String text = inputFromFile1.nextLine();
   String text2 = text.replaceAll("[a-zA-z\\W]"," ");
               
    output.print(text2);
    
    }
    
    
    output.flush();
    output.close();
    
   Scanner input=new Scanner(new File("output.txt")); 
    while (input.hasNext()) {

            int  number= input.nextInt();
            
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    number = input.nextInt();
                    i = 1;
                }

            }
    System.out.print(number+" ");
        }
   
    
    }
    
}
