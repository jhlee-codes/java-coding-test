import java.util.*;

class Solution {
    public int[] solution(String s) {

        // {{, }} 제거
        String clean = s.substring(2, s.length() - 2);
        
        // "},{“ 기준으로 분리 
        String[] arr = clean.split("\\},\\{");
        
        // 작은 집합 -> 큰 집합 순으로 정렬
        Arrays.sort(arr, Comparator.comparingInt(a -> a.split(",").length));
        
        // 순서 유지를 위해 LinkedHashSet 사용
        Set<Integer> result = new LinkedHashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            String[] arr2 = arr[i].split(",");
            for (int j = 0; j < arr2.length; j++) {
                result.add(Integer.parseInt(arr2[j]));
            }
        }

        // Set -> int[] 변환
        int[] answer = new int[result.size()];
        int i = 0;
        for (int v : result) {
            answer[i++] = v;
        }
        
        return answer;
    }
}