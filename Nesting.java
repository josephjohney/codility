// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // Implement your solution here
        char[] s= S.toCharArray();
        int N = s.length;

        Stack <String> stack =new Stack<String>();



        for (int i =0; i <N; i++){
            if (s[i]==')'){
                if (!stack.isEmpty()&&stack.peek()=="("){
                    stack.pop();
                    continue;
                }

            }
            stack.push("(");
        }
        if(stack.isEmpty()){
            return 1;
        }
        else return 0;
 
    }
}