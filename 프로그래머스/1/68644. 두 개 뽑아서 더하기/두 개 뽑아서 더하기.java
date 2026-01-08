import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> sum = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sum.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = sum.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}