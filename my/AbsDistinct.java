
import java.util.*;
import java.util.stream.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        // int N = A.length;

       Set<Integer> set= Arrays.stream(A).boxed().map(i->Math.abs(i)).collect(Collectors.toSet());
       return set.size();

    }
} {
    
}
