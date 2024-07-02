 
package lap1;


public class Lap1 {

    
    public static void main(String[] args) {
       
        char[] key = {'D', 'B', 'D', 'C', 'C', 'D'};

        char[][] ans = {
            {'A', 'B', 'A', 'C', 'C', 'D'},
            {'D', 'B', 'A', 'B', 'C', 'A'},
            {'E', 'D', 'D', 'A', 'C', 'B'},
            {'C', 'B', 'A', 'E', 'D', 'C'}
        };

        for (int i = 0; i < ans.length; i++) {

            int counter = 0;

            for (int j = 0; j < ans[i].length; j++) {

                if (ans[i][j] == key[j]) {
                    counter++;
                }

            }

            System.out.println("Student " + (i + 1) + "'s correct count is " + counter + " out of 6");
        }

       
    
    
//    char [] keyAnswer={'D','B','D','C','C','D'};
//    char [][] stuAnswer={
//            {'A', 'B', 'A', 'C', 'C', 'D'},
//            {'D', 'B', 'A', 'B', 'C', 'A'},
//            {'E', 'D', 'D', 'A', 'C', 'B'},
//            {'C', 'B', 'A', 'E', 'D', 'C'}};
//
//    
//    
//        for (int i = 0; i < stuAnswer.length; i++) {
//            
//            int counter=0;
//            for (int j = 0; j <stuAnswer[i].length; j++) {
//               if(stuAnswer[i][j]==keyAnswer[j]){
//               counter++;
//               } 
//            }
//        System.out.println("Student " + (i + 1) + "'s correct count is " + counter + " out of 6");
//        }
//    
//    
//    
//    
    
    
    
    
    
    
    }
    
}
