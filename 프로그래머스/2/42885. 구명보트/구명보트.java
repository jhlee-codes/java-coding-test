import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 몸무게 오름차순 정렬
        Arrays.sort(people);
        
        int minIdx = 0;
        int maxIdx = people.length - 1;
        
        while (minIdx <= maxIdx) {
            int max = people[maxIdx];
            int min = people[minIdx];
            
            // 가장 무거운 사람 + 가벼운사람 조합이 limit 이하 -> 가벼운사람도 같이 태움 (idx++)
            if (max + min <= limit) {
                minIdx++;
            }
            
            // 무거운 사람은 항상 태움
            maxIdx--;
            answer++;
        }

        return answer;
    }
}