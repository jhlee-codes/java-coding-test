import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        Queue<Integer> progressesQ = new ArrayDeque<>();
        Queue<Integer> speedsQ = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            progressesQ.add(progresses[i]);
            speedsQ.add(speeds[i]);
        }
        
        int day = 0;
        int cnt = 0;
        
        while (!progressesQ.isEmpty()) {
            
            day++;
            cnt = 0;
            
            while (!progressesQ.isEmpty() && progressesQ.peek() + speedsQ.peek() * day >= 100) {
                progressesQ.poll();
                speedsQ.poll();
                cnt++;
            }
            
            if (cnt > 0) {
                result.add(cnt);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}