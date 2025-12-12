import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {  
        String answer = "";
        HashMap<String, Integer> completionMap = new HashMap<>();
        
        for (int i = 0; i < completion.length; i++) {
            int cnt = 1;
            String targetKey = completion[i];
            if (completionMap.containsKey(targetKey)) {
                cnt = completionMap.get(targetKey);
                completionMap.put(completion[i], cnt + 1);
            } else {
                completionMap.put(completion[i], cnt);
            }   
        }

        for (String target : participant) {
            int cnt = 0;
            if (completionMap.containsKey(target)) {
                cnt = completionMap.get(target);
                completionMap.put(target, cnt - 1);
                if (cnt < 1) {
                    answer = target;
                }
            } else {
                answer = target;
            }
        }
        return answer;
    }
}