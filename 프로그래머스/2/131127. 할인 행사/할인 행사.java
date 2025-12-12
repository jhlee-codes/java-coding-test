import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        int cnt = 0;
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            
            HashMap<String, Integer> dcMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    dcMap.put(discount[j], dcMap.getOrDefault(discount[j], 0) + 1);
                } 
            }
            
            if (dcMap.equals(wantMap)) cnt++;
            
        }
        
        return cnt;
    }
}