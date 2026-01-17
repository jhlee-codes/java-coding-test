import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {  
        Map<String, Integer> cpMap = new HashMap<>();
        
        for (int i = 0; i < completion.length; i++) {
            String cur = completion[i];
            cpMap.put(cur, cpMap.getOrDefault(cur, 0) + 1);
        }
        
        for (String str : participant) {
            if (cpMap.containsKey(str) && cpMap.get(str) > 0) {
                cpMap.put(str, cpMap.getOrDefault(str, 0) - 1);
            } else {
                return str;
            }
        }
        
        return "";
    }
}