import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        
        // n / 2 수 구하기
        int amount = nums.length / 2;
        
        // nums 배열을 set에 넣어 중복 제거
        Set<Integer> pkms = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet());
        
        // 최소값 비교
        int answer = Math.min(amount, pkms.size());
        return answer;
    }
}