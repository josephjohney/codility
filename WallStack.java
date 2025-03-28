import java.util.*;

class Solution {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int h : H) {
            while (!stack.isEmpty() && stack.peek() > h) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < h) {
                stack.push(h);
                count++;
            }
        }
        return count;
    }
}