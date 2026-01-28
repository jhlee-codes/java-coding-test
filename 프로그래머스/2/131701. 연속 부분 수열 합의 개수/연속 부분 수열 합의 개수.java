import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> sumSet = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            q.addLast(elements[i]);
        }
        
        for (int i = 0; i < n ; i++) {
            int sum = 0;
            int len = 0;

            for (int v : q) {
                sum += v;
                len++;
                sumSet.add(sum);
                if (len == n) break;
            }
            
            q.addLast(q.pollFirst());
        }
    
        return sumSet.size();
    }
}