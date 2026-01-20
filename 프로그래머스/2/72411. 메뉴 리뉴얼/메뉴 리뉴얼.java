import java.util.*;

class Solution {

    public String[] solution(String[] orders, int[] course) {
        // 코스 길이별 조합 카운트
        Map<Integer, Map<String, Integer>> cntByCourse = new HashMap<>();
        
        for (String order : orders) {
            char[] items = order.toCharArray();
            Arrays.sort(items);
            
            for (int c : course) {
                if (items.length < c) continue;
                Map<String, Integer> inner = cntByCourse.computeIfAbsent(c, m -> new HashMap<>());
                // dfs로 길이가 c인 조합 만들기
                dfs(items, 0, c, new StringBuilder(), inner);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (int c : course) {
            Map<String, Integer> inner = cntByCourse.get(c);
            if (inner == null) continue;
            
            int max = 0;
            for (int v : inner.values()) max = Math.max(max, v);
            
            if (max < 2) continue;
            
            for (Map.Entry<String, Integer> e : inner.entrySet()) {
                if (e.getValue() == max) result.add(e.getKey());
            }
        }
        
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
   
    private void dfs(char[] arr, int start, int cnt, StringBuilder sb, Map<String, Integer> map) {
        // 조합 완성시 카운트 + 1
        if (sb.length() == cnt) {
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            sb.append(arr[i]);
            dfs(arr, i + 1, cnt, sb, map);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }
}