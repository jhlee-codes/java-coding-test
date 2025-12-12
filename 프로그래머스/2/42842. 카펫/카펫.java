import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 블록 전체 개수 = brown + yellow
        int total = brown + yellow;
        int width, height;
        
        // 약수 구하기
        List<Integer> divisorList = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
            if (total % i == 0) {
                divisorList.add(i);
            }
        }
        
        for (int i = 0; i < divisorList.size(); i++) {
            height = divisorList.get(i);
            width = total / height;
            
            // yellow = (width - 2) * (height - 2)
            if (yellow == (width - 2) * (height - 2)) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        return answer;
    }
}