import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (cur % divisor == 0) {
                list.add(cur);
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}