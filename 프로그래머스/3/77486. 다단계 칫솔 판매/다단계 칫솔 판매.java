import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        // {추천 대상 : 추천인}
        Map<String, String> parentMap = new HashMap<>();
        // {판매원 : 이익금}
        Map<String, Integer> profitMap = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            String parent = referral[i];
            String child = enroll[i];
            
            parentMap.put(child, parent);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String target = seller[i];
            int total = amount[i] * 100;
            
            while (!target.equals("-") && total > 0) {
                int pass = total / 10;
                int keep = total - pass;
                
                profitMap.put(target, profitMap.getOrDefault(target, 0) + keep);
                
                String refTarget = parentMap.get(target);
                
                target = refTarget;
                total = pass;
            }
        }
    
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}