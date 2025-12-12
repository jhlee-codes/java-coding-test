import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 블록 전체 개수 = brown + yellow
        int total = brown + yellow;
        
        for (int w = 3; w < total; w++) {
            
            if (total % w != 0) continue;
            int h = total / w;
            
            // yellow = (width - 2) * (height - 2)
            if (yellow == (w - 2) * (h - 2)) {
                // width >= height
                answer[0] = Math.max(w, h);
                answer[1] = Math.min(w, h);
                break;
            }
        }

        return answer;
    }
}