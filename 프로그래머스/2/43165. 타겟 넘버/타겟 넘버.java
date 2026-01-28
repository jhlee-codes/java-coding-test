import java.util.*;

class Solution {
    
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {   
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    private void dfs(int sum, int idx, int[] numbers, int target) {
        
        if (idx == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        
        int cur = numbers[idx];
        
        // 더하기, 빼기 두 가지 경우 재귀 호출
        dfs(sum + cur, idx + 1, numbers, target);
        dfs(sum - cur, idx + 1, numbers, target);
    }
}