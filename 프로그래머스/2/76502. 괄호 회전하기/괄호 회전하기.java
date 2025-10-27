import java.util.*;

class Solution {
    public int solution(String s) {        
        int n = s.length();
        // n이 홀수면 실패
        if (n % 2 == 1) {
            return 0;
        }
        
        int answer = 0;
        
        HashMap<Character, Character> map = new HashMap<>();
        
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
           
        for (int i = 0; i < s.length(); i++) {

            // 올바른 괄호인지 판단
            Stack<Character> stack = new Stack<>();
            
            boolean isValid = true;
            
            for (int j = 0; j < n; j++) {
                // 회전 인덱스
                char c = s.charAt((i + j) % n);
                if (map.containsKey(c)) {
                    // 여는 괄호
                    stack.push(c);
                } else {
                    // 닫는 괄호
                    if (stack.isEmpty()) { 
                        isValid = false; 
                        break; 
                    }
                    char open = stack.pop();
                    if (map.get(open) != c) { 
                        isValid = false; 
                        break; 
                    }
                    isValid = true;
                }
            }
            
            if (isValid && stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}