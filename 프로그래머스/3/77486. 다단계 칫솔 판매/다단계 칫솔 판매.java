import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // {판매원 : 추천인}
        Map<String, String> referralMap = new HashMap<>();
        // {판매원 : 이익금}
        Map<String, Integer> profitMap = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            referralMap.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String target = seller[i];
            int total = amount[i] * 100;
            
            // 판매 이익 분배 (루트 방향)
            while (!target.equals("-") && total > 0) {
                int margin = total / 10;    // 추천인 이익 (10%)
                int keep = total - margin;  // 본인 판매 이익 (90%)
                
                profitMap.put(target, profitMap.getOrDefault(target, 0) + keep);
                
                // 부모 노드로 이동 (추천인)
                target = referralMap.get(target);
                total = margin;
            }
        }
        
        int[] result = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            result[i] = profitMap.get(enroll[i]);
        }
        
        return result;
    }
}