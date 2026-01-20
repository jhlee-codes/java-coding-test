import java.util.*;

class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // {유저 : id}
        Map<String, Integer> userMap = new HashMap<>();
        // {target : 신고자 Set}
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        int[] result = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) userMap.put(id_list[i], i);
        
        for (int i = 0; i < report.length; i++) {
            String[] cur = report[i].split(" ");
            String user = cur[0];
            String target = cur[1];
            
            reportMap.computeIfAbsent(target, r -> new HashSet<>()).add(user);
        }
        
        for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {
            // 신고 횟수가 k번 이상이면 신고한 유저 처리 결과 메일 + 1
            if (entry.getValue().size() >= k) {
                for (String u : entry.getValue()) {
                    int idx = userMap.get(u);
                    result[idx] += 1;
                }
            }
        }
        
        return result;
    }
}