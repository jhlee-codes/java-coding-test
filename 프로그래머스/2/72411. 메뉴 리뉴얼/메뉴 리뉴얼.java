import java.util.*;
/* 코딩테스트 합격자되기 답안 참고 -> 혼자 다시 풀어보기 */
class Solution {
    
    // {메뉴 개수 : {메뉴 구성 : 총 주문 수}}
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        
        courseMap = new HashMap<>();
        
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }
        
        // 코스를 배열로 만들고 오름차순 정렬 후 가능한 모든 메뉴 구성
        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }
        
        List<String> answer = new ArrayList<>();
        
        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(cnt -> count.entrySet()
                          .stream()
                          .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                          .forEach(entry -> answer.add(entry.getKey())));
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    // 만들 수 있는 모든 조합을 만드는 재귀 함수
    private static void combinations(int idx, char[] order, String result) {
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            // 카운트 1 증가
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        
        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }
}