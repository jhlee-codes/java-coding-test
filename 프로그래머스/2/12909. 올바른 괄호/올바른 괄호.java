import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') return false;
        
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            
            if (cur == '(') {
                stack.addLast(cur);
            } else {
                if (stack.isEmpty()) return false;
                stack.pollLast();
            }
        }
        
        return stack.isEmpty();
    }
}