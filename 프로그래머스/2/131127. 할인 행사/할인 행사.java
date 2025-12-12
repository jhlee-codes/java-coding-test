import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        int cnt = 0;
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            
            HashMap<String, Integer> wantMapCp = new HashMap<>(wantMap);
            for (int j = i; j < i + 10; j++) {
                if (wantMapCp.containsKey(discount[j])) {
                    int num = wantMapCp.getOrDefault(discount[j], 0) - 1;
                    if (num > 0) {
                        wantMapCp.put(discount[j], num);
                    } else {
                        wantMapCp.remove(discount[j]);
                    }
                } 
            }
            
            if (wantMapCp.isEmpty()) cnt++;
            
        }
        
        return cnt;
    }
}