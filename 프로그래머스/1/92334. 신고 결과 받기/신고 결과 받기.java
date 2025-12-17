import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // {신고한 사람:신고 당한 사람 배열}
        // 중복 제거 -> Set
        Map<String, Set<String>> userReportMap = new HashMap<>();
        // {신고 당한 사람:신고 횟수}  
        Map<String, Integer> reportCntMap = new HashMap<>();
        
        for (int i = 0; i < report.length; i++) {
            String user = report[i].split(" ")[0];
            String reportUser = report[i].split(" ")[1];
            
            // Set에 추가될때(중복이 아닐때)만 신고 횟수 + 1
            Set<String> set = userReportMap.computeIfAbsent(user, r -> new HashSet<>());
            if (set.add(reportUser)) {
                reportCntMap.put(reportUser, reportCntMap.getOrDefault(reportUser, 0) + 1);            
            }
        }
        
        // 신고 횟수가 k번 이상인 유저 리스트
        Set<String> blackList = new HashSet<>();
        
        reportCntMap.forEach((key, value) -> {
            if (value >= k) {
                blackList.add(key);
            }
        });
        
        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            Set<String> targetSet = userReportMap.getOrDefault(reporter, Collections.emptySet());
            
            int cnt = 0;
            for (String user : targetSet) {
                if (blackList.contains(user)) {
                    cnt ++;
                }
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}