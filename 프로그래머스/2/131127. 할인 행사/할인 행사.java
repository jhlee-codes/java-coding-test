import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
    
        Map<String, Integer> wantMap = new HashMap<>();
        
        int result = 0;
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> dcMap = new HashMap<>();
            boolean isOk = true;

            for (int j = i; j < i + 10; j++) {
                String item = discount[j];
                dcMap.put(item, dcMap.getOrDefault(item, 0) + 1);
            }
            
            for (int j = 0; j < want.length; j++) {
                String cur = want[j];
                // wantMap 보다 숫자가 작으면 카운트 포함 x
                if (wantMap.get(cur) > dcMap.getOrDefault(cur, 0)) {
                    isOk = false;
                    break;
                }
            }
            
            if (isOk) result++;
        }
        return result;
    }
}