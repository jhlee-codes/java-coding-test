import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // {유저 : 다음 달 받을 선물 개수}
        Map<String, Integer> userMap = new HashMap<>();
        
        // {준 사람 : {받은 사람 : 선물 개수}}
        Map<String, Map<String, Integer>> giftMap = new HashMap<>();
        
        // {유저 : 선물 지수}
        Map<String, Integer> giftIdxMap = new HashMap<>();
        
        // 선물 지수 계산을 위한 총합 맵
        Map<String, Integer> giveTotal = new HashMap<>();
        Map<String, Integer> receiveTotal = new HashMap<>();
        
        // 초기화
        for (String f : friends) {
            userMap.put(f, 0);
            giftIdxMap.put(f, 0);
            giveTotal.put(f, 0);
            receiveTotal.put(f, 0);
        }
        
        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String from = gift[0];
            String to = gift[1];
            
            Map<String, Integer> inner = giftMap.computeIfAbsent(from, m -> new HashMap<>());
            inner.put(to, inner.getOrDefault(to, 0) + 1);
            
            giveTotal.put(from, giveTotal.get(from) + 1);
            receiveTotal.put(to, receiveTotal.get(to) + 1);
        }
        
        // 선물 지수 계산
        for (String f : friends) {
            int idx = giveTotal.get(f) - receiveTotal.get(f);
            giftIdxMap.put(f, idx);
        }
        
        // 다음 달 받을 선물 개수 계산
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String a = friends[i];
                String b = friends[j];
                
                int aTob = giftMap.getOrDefault(a, Collections.emptyMap()).getOrDefault(b, 0);
                int bToa = giftMap.getOrDefault(b, Collections.emptyMap()).getOrDefault(a, 0);
                
                if (aTob > bToa) {
                    userMap.put(a, userMap.get(a) + 1);
                } else if (bToa > aTob) {
                    userMap.put(b, userMap.get(b) + 1);
                } else {
                    // 선물 지수 비교
                    int aIdx = giftIdxMap.get(a);
                    int bIdx = giftIdxMap.get(b);
                    
                    if (aIdx > bIdx) {
                        userMap.put(a, userMap.get(a) + 1);
                    } else if (bIdx > aIdx) {
                        userMap.put(b, userMap.get(b) + 1);
                    }
                }
            }
        }
        
        int answer = 0;
        
        for (String f : friends) {
            answer = Math.max(userMap.get(f), answer);
        }
        
        return answer;
    }
}