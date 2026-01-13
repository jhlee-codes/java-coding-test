import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peekLast()] > prices[i]) {
                int t = stack.pollLast();
                answer[t] = i - t;
            }
            stack.addLast(i);
            
        }
        
        while (!stack.isEmpty()) {
            int t = stack.pollLast();
            answer[t] = (n - 1) - t; 
        }
        
        return answer;
    }
}