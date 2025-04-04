// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution( int[] A) {
        // Implement your solution here
        int N= A.length;

        if(N<3) return 0;

        Arrays.sort(A);


        int count =0;

        for(int R =2; R <N; R++){
            int P=0, Q=R-1;
           while (P <Q) {
               if((A[P]+A[Q])>A[R]){
                   count += (Q-P);
                   Q--;
               }else {


                P ++;
               }
            }

        }   

        return count;

    
    }
}