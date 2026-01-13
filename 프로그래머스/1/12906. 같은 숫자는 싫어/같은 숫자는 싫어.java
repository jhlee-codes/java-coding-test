import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && (stack.peekLast() == arr[i])) {
                stack.pollLast();
            }
            stack.addLast(arr[i]);
        }
        
        while(!stack.isEmpty()) {
            ans.add(stack.pollFirst());
        }
        
        return ans.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}