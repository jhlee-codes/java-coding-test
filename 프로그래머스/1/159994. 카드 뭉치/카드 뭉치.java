import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        Queue<String> cards1Q = new ArrayDeque<>();
        Queue<String> cards2Q = new ArrayDeque<>();
        Queue<String> goalQ = new ArrayDeque<>();
        
        for (int i = 0; i < cards1.length; i++) {
            cards1Q.add(cards1[i]);
        }
        
        for (int i = 0; i < cards2.length; i++) {
            cards2Q.add(cards2[i]);
        }
        
        for (int i = 0; i < goal.length; i++) {
            goalQ.add(goal[i]);
        }
        
        while(!goalQ.isEmpty()) {
            
            String target = goalQ.peek();
            
            if (target.equals(cards1Q.peek())) {
                cards1Q.poll();
                goalQ.poll();
            } else if (target.equals(cards2Q.peek())) {
                cards2Q.poll();
                goalQ.poll();
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}