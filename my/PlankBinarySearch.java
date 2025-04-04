package my;

import java.util.*;



class Solution {
    public int solution(int[] A, int[] B, int[] C) {
        int N = A.length, M = C.length;
        
        // Step 1: Store nails with their original index before sorting
        int[][] nails = new int[M][2];
        for (int i = 0; i < M; i++) {
            nails[i][0] = C[i]; // Nail position
            nails[i][1] = i;    // Original index
        }
        
        // Step 2: Sort nails by position
        Arrays.sort(nails, Comparator.comparingInt(a -> a[0]));

        int minNailsUsed = 0;

        // Step 3: Try to nail each plank with the minimum number of nails
        for (int i = 0; i < N; i++) {
            int plankStart = A[i];
            int plankEnd = B[i];

            int nailIndex = findEarliestNail(nails, plankStart, plankEnd);
            if (nailIndex == -1) return -1; // No nail found for this plank
            
            minNailsUsed = Math.max(minNailsUsed, nailIndex + 1); // Use minimum nails
        }

        return minNailsUsed;
    }

    // Binary search to find the first nail within the range [plankStart, plankEnd]
    private int findEarliestNail(int[][] nails, int plankStart, int plankEnd) {
        int left = 0, right = nails.length - 1;
        int minIndex = Integer.MAX_VALUE;

        // Binary search to find the first nail >= plankStart
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nails[mid][0] < plankStart) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Now, check all nails from index `left` to find the minimum valid index
        for (int i = left; i < nails.length && nails[i][0] <= plankEnd; i++) {
            minIndex = Math.min(minIndex, nails[i][1]); // Keep track of the earliest nail used
        }

        return (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
    }
}
