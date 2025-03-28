// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int N= A.length;
        int result=0;
        int zeros = 0;

        for(int i =0;i<N ;i++   ){
            if(A[i]==0){
                zeros ++;
            }
            else{
                result = result +zeros;
            }

            if(result >1000000000){
                result =-1;
            }
        }
        return result;
    }
}

