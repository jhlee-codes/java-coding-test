import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        Set<Integer> mons = new HashSet<>();
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            mons.add(nums[i]);
        }
        
        if (mons.size() > n / 2) {
            answer = n / 2;
        } else {
            answer = mons.size();
        }
        
        return answer;
    }
}