class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int removeZero = 0;
        
        while (!s.equals("1")) {
            
            // 1. x의 모든 0을 제거
            int zeroCnt = s.length() - s.replace("0","").length();
            removeZero += zeroCnt;
            s = s.replace("0", "");

            // 2. x의 길이를 2진법으로 표현한 문자열로 바꾸기
            s = Integer.toBinaryString(s.length());
            
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = removeZero;
        
        return answer;
    }
}