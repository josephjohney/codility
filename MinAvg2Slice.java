// you can also use imports, for example:
import java.util.*;
import java.util.stream.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
   public static int solution(int[] A) {


        double minAvg = Double.MAX_VALUE;
        int minIndex = 0;

        int N = A.length;


        for (int i = 0; i < N; i++) {

            for (int j = i + 1; j < N; j++) {

                int sum = 0;
                int counter = 0;

                for (int k = i; k <= j; k++) {

                    sum += A[k];
                    counter++;
                }

                double avg = (double) sum / (double) counter;

                if (avg < minAvg) {

                    minAvg = avg;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }
}