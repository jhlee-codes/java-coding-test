import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int answer = 0;
        // 프로세스 idx 큐
        ArrayDeque<Integer> idxQ = new ArrayDeque<>();
        // 우선순위 (최대 힙)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            idxQ.addLast(i);
            maxHeap.add(priorities[i]);
        }
        
        while(!idxQ.isEmpty()) {
            int idx = idxQ.pollFirst();
            int cur = priorities[idx];
            
            // 현재 우선순위 중 최댓값인 경우
            if (cur == maxHeap.peek()) {
                maxHeap.poll();
                answer++;
                if (idx == location) return answer;
            } else {
                idxQ.addLast(idx);
            }
        }

        return answer;
    }
}