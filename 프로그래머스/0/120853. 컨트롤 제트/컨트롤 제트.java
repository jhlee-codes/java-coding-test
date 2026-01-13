import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String token : s.split(" ")) {
            if (token.equals("Z")) {
                int num = stack.pollLast();
                answer -= num;
            } else {
                int num = Integer.parseInt(token);
                answer += num;
                stack.addLast(num);
            }
        }

        return answer;
    }
}