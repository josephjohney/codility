// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int M, int[] A) {
        // Implement your solution here
        int N= A.length;
        int back = 0, count =0;
        boolean [] seen =new boolean[M+1];

        for(int front =0; front <N; front++){

           while (back < N && !seen[A[back]]) {
                seen[A[back]]=true;

               count += (back - front + 1); 

                if (count > 1_000_000_000) return 1_000_000_000;

                back ++;

            }
            seen[A[front]]= false;

        }   

        return count;

    
    }
}