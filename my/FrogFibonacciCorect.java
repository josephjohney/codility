

// you can also use imports, for example:
import java.util.*;
  class Jump {

        int pos;
        int move;
        public Jump(int pos, int move) {
            this.pos = pos;
            this.move = move;
        }
    }
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
   public int solution(int[] A) {

        int n = A.length;
        List < Integer > fibs = fibArray(n + 1);
        Queue < Jump > positions = new LinkedList < Jump > ();
        boolean[] visited = new boolean[n + 1];

        if (A.length <= 2)
            return 1;

        for (int i = 0; i < fibs.size(); i++) {
            int initPos = fibs.get(i) - 1;
            if (A[initPos] == 0 || visited[initPos])
                continue;
            positions.add(new Jump(initPos, 1));
            visited[initPos] = true;
        }

        while (!positions.isEmpty()) {
            Jump jump = positions.remove();
            for (int j = fibs.size() - 1; j >= 0; j--) {
                int nextPos = jump.pos + fibs.get(j);
                if (nextPos == n)
                    return jump.move + 1;
                else if (nextPos < n && A[nextPos] == 1 && !visited[nextPos]) {
                    positions.add(new Jump(nextPos, jump.move + 1));
                    visited[nextPos] = true;
                }
            }
        }


        return -1;
    }


    private List < Integer > fibArray(int n) {
        List < Integer > fibs = new ArrayList < > ();
        fibs.add(1);
        fibs.add(2);
        while (fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2) <= n) {
            fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
        }
        return fibs;
    }