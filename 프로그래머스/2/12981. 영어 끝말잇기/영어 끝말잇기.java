import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> used = new HashSet<>();
        char last = words[0].charAt(words[0].length() - 1);
        used.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            char first = cur.charAt(0);
            
            if (last != first || used.contains(cur)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            
            last = cur.charAt(cur.length() - 1);
            used.add(cur);
        }
        
        return new int[]{0,0};
    }
}