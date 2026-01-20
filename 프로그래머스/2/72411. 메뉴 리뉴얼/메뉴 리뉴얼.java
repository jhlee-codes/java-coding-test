import java.util.*;

class Solution {

    public String[] solution(String[] orders, int[] course) {
        // 코스 길이별 조합 카운트 - {길이 : {메뉴조합 : 카운트}}
        Map<Integer, Map<String, Integer>> cntByCourse = new HashMap<>();
        
        for (String order : orders) {
            char[] items = order.toCharArray();
            // 메뉴 정렬
            Arrays.sort(items);
            
            for (int c : course) {
                if (items.length < c) continue;
                Map<String, Integer> inner = cntByCourse.computeIfAbsent(c, m -> new HashMap<>());
                // dfs로 길이가 c인 조합 모두 만들고 카운트 누적
                dfs(items, 0, c, new StringBuilder(), inner);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (int c : course) {
            Map<String, Integer> inner = cntByCourse.get(c);
            if (inner == null) continue;
            
            // 길이 c 조합들 중 최댓값 찾기
            int max = 0;
            for (int v : inner.values()) max = Math.max(max, v);
            
            if (max < 2) continue;
            
            // 최댓값과 같은 조합들 결과에 추가
            for (Map.Entry<String, Integer> e : inner.entrySet()) {
                if (e.getValue() == max) result.add(e.getKey());
            }
        }
        
        // 사전순 정렬
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
   
    // 메뉴 조합 생성 (DFS + 백트래킹)
    // ex. ABC, ABF, ABG, ACF, ACG, AFG ...
    private void dfs(char[] arr, int start, int cnt, StringBuilder sb, Map<String, Integer> map) {
        // 기저 조건: 조합의 길이가 목표 길이(cnt)에 도달
        if (sb.length() == cnt) {
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            sb.append(arr[i]);
            dfs(arr, i + 1, cnt, sb, map);
            // 백트래킹: 방금 추가했던 문자 제거 (다른 경우의 수 탐색을 위함)
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}