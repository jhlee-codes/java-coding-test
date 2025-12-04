class Solution {
    public int solution(int n) {
        int cnt = 0;
        
        // 약수 중 홀수의 개수와 동일
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && i % 2 == 1) {
                cnt++;
            }
        }
        
        return cnt;
    }
}