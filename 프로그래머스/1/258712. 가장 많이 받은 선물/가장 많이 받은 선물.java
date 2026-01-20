import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int n = friends.length;
        Map<String, Integer> userMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) userMap.put(friends[i], i);
        
        int[][] giftArr = new int[n][n];
        int[] gIdxArr = new int[n];
        int[] result = new int[n];
        
        for (int i = 0; i < gifts.length; i++) {
            String[] cur = gifts[i].split(" ");
            int from = userMap.get(cur[0]);
            int to = userMap.get(cur[1]);
            
            // 선물지수 업데이트
            gIdxArr[from]++;
            gIdxArr[to]--;
            // 준 선물 개수 업데이트
            giftArr[from][to]++;
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                int a = userMap.get(friends[i]);
                int b = userMap.get(friends[j]);
                
                // 준 선물 개수 비교
                if (giftArr[a][b] > giftArr[b][a]) {
                    result[a]++;
                } else if (giftArr[b][a] > giftArr[a][b]) {
                    result[b]++;
                } else {
                    // 선물지수 비교
                    if (gIdxArr[a] > gIdxArr[b]) {
                        result[a]++;
                    } else if (gIdxArr[b] > gIdxArr[a]) {
                        result[b]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < result.length; i++) {
            answer = Math.max(result[i], answer);
        }
        
        return answer;
    }
}