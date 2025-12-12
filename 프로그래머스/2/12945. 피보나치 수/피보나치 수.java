import java.util.*;

class Solution {
    
    private static final int MOD = 1234567;
    private int[] memo;
    
    public int solution(int n) {
        
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        
        return recursive(n);
    }
    
    public int recursive(int n) {
        
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != -1) return memo[n];
        
        // 매 연산마다 MOD 적용 (오버플로우 방지)
        memo[n] = (recursive(n - 1) + recursive(n - 2)) % MOD;
        
        return memo[n];
    }
}