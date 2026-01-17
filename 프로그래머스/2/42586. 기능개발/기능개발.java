import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        // 1. 작업 진도 큐 생성
        for (int i = 0; i < progresses.length; i++) {
            queue.addLast(progresses[i]);
        } 
        
        // 2. 앞 작업부터 완료 여부 확인
        int round = 1;  // 경과 일수
        int idx = 0;    // speeds 배열 인덱스
        int cnt = 0;    // 배포 작업 개수
        while (queue.size() > 0) {
            int target = queue.getFirst();
            
            if (target + speeds[idx] * round >= 100) {
                queue.pollFirst();
                idx ++;
                cnt ++;
            } else {
                // cnt가 0 이상이면 배포 결과 반영 후 초기화
                if (cnt > 0) {
                    result.add(cnt);
                    cnt = 0;
                }
                round ++;
            }
            
            // 마지막 작업 배포 반영
            if (queue.size() == 0) {
                result.add(cnt);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}