// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*
 * Task description
For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:

val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|

(Assume that the sum of zero elements equals zero.)

For a given array A, we are looking for such a sequence S that minimizes val(A,S).

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

For example, given array:

  A[0] =  1
  A[1] =  5
  A[2] =  2
  A[3] = -2
your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..20,000];
each element of array A is an integer within the range [−100..100].
Copyright 2009–2025 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

class Solution {
     public  int solution(int[] A) {

        int N = A.length;

        int sum = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {

            A[i] = Math.abs(A[i]);
            sum += A[i];

            max = Math.max(A[i], max);
        }

        int[] counts = new int[max + 1];

        for (int i = 0; i < N; i++) {
            counts[A[i]] += 1;
        }




        /*
         * SUBSET SUM PROBLEM
         * ------------------
         *
         * Given a set (or multiset) of integers, is there a non-empty subset whose sum is zero?
         *
         * For example, given the set {-7, -3, -2, 5, 8}, the answer is yes because the subset
         *
         * {-3, -2, 5} sums to zero. The problem is NP-complete, meaning roughly that while it
         *
         * is easy to confirm whether a proposed solution is valid, it may inherently be prohibi
         * tively
         * difficult to determine in the first place whether any solution exists.
         *
         *
         * An equivalent problem: given a set of integers and an integer s, does any non-empty subset
         * sum to s?
         *
         *
         *
         * KNAPSACK PROBLEM
         * ----------------
         * Given a set of items, each with a weight and a value, determine the number of each item
         *
         * included in a collection so that the total weight is less than or equal to a given limit
         *
         * and the total value is as large as possible.
         *
         *
         *
         *
         * PARTITION PROBLEM
         * -----------------
         *
         * It is the task of deciding whether a given multiset S of positive integers can be partitioned
         *
         * into two subsets S1 and S2 such that the sum of the numbers in S1 equals the sum of the numbe
         * rs
         * in S2. Although the partition problem is NP-complete, there is a pseudo-polynomial time dynam
         * ic
         * programming solution, and there are heuristics that solve the problem in many instances, eith
         * er
         * optimally or approximately. For this reason, it has been called "the easiest NP-hard problem"
         * .
         * There is an optimization version of the partition problem, which is to partition the multiset
         * S
         * into two subsets S1, S2 such that the difference between the sum of elements in S1 and the su
         * m
         * of elements in S2 is minimized. The optimization version is NP-hard but can be solved efficie
         * ntly in practice.
         *
         *
         * */

        int[] Total = new int[sum + 1];

        Arrays.fill(Total, -1);
//        Arrays.fill(Total, 1, Total.length, -1);
        Total[0] = 0;


        for (int i = 1; i <= max; i++) {

            if (counts[i] > 0) {

                for (int j = 0; j <= sum; j++) {

                    /*
                     * j th index is zero or positive
                     * */
                    if (Total[j] >= 0) {
                        Total[j] = counts[i];
                    }

                    /*
                     * (i-j) th index is positive
                     * */
                    else if ((j - i) >= 0 && Total[j - i] > 0) {
                        Total[j] = Total[j - i] - 1;
                    }
                }
            }
        }



        int result = sum;

        for (int i = 0; i < (sum/2) + 1; i++) {

            /*
             * i- th index if zero or positive
             * BODMAS  =  {Brackets, Orders, Division, Multiplication, Addition, Subtraction}
             * */

            /*
                BODMAS
                ------

                    Bracket
                    Of
                    Division
                    Multiplication
                    Addition
                    Subtraction
            */
            if (Total[i] >= 0) {
                result = Math.min(result, sum - 2 * i);
            }
        }

        return result;
    }
}