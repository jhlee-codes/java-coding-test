import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cards1Q = new ArrayDeque<>();
        ArrayDeque<String> cards2Q = new ArrayDeque<>();
        
        for (int i = 0; i < cards1.length; i++) {
            cards1Q.addLast(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            cards2Q.addLast(cards2[i]);
        }
        
        for (int i = 0; i < goal.length; i++) {
            String target1 = cards1Q.peekFirst();
            String target2 = cards2Q.peekFirst();
            if (goal[i].equals(target1)) cards1Q.pollFirst();
            else if (goal[i].equals(target2)) cards2Q.pollFirst();
            else return "No";
        }
        
        return "Yes";
    }
}