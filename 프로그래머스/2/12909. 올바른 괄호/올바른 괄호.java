import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (target == '(') {
                stack.push(target);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}