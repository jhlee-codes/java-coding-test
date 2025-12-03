class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            int target = Integer.parseInt(arr[i]);
            max = max < target ? target : max;
            min = min > target ? target : min;
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}