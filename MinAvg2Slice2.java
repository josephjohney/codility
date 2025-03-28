class Solution {
    public static int solution(int[] A) {
        int N = A.length;

        // Initialize minimum average and the index of the subarray
        double minAvg = (A[0] + A[1]) / 2.0;
        int minIndex = 0;

        // Iterate over the array to check pairs and triplets
        for (int i = 0; i < N - 1; i++) {
            // Check the average of the pair starting at index i
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            if (avg2 < minAvg) {
                minAvg = avg2;
                minIndex = i;
            }

            // Check the average of the triplet starting at index i
            if (i < N - 2) {
                double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (avg3 < minAvg) {
                    minAvg = avg3;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }
}