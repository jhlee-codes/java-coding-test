import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {  
        HashMap<String, Integer> completionMap = new HashMap<>();
        
        for (int i = 0; i < completion.length; i++) {
            String targetKey = completion[i];
            completionMap.put(targetKey, completionMap.getOrDefault(targetKey, 0) + 1);  
        }

        for (String target : participant) {
            int cnt = completionMap.getOrDefault(target, 0);
            if (cnt == 0) return target;
            completionMap.put(target, cnt - 1);
        }
        return "";
    }
}