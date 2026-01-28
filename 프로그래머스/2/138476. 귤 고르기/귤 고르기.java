import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {        
        // {크기: 개수}
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        // 개수 기준 내림차순
        List<Integer> cntList = new ArrayList<>(map.values());
        cntList.sort(Collections.reverseOrder());
        
        int sum = 0;
        int answer = 0;
        
        for (int c : cntList) {
            sum += c;
            answer++;
            if (sum >= k) break;
        }
        
        return answer;
    }
}