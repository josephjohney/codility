// you can also use imports, for example:
import java.util.*;
import java.util.Stream.*;
import java.util.stream.Collectors;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
    
        int N=A.length;

       int[] fib = getFib(N);
        System.out.println("Fibonacci:");
        Arrays.stream(fib).boxed().forEach(System.out::println);
        List<Integer> list = Arrays.stream(fib).boxed().collect(Collectors.toList());
        int count =0;


        for(int i=0; i<N;i++){
            if(A[i]==1 && list.contains(i+1)){
                count++;
            }
        }

        return count;

    }

    private static int[] getFib(int N) {
        int[] fib = new int[N + 2];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= N + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
    
}
