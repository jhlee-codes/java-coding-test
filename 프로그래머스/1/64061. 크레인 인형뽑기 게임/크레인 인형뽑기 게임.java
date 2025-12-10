import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        
        Stack<Integer> pick = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                // board를 순회하며 해당 인덱스에 값이 0이 아니면 인형이 있는 상태
                int target = board[j][moves[i]-1];
                if (target != 0) {
                    // 해당 위치의 인형을 뺌 (0)
                    board[j][moves[i]-1] = 0;
                    if (pick.size() > 0 && pick.peek() == target) {
                        pick.pop();
                        result += 2;
                    } else {
                        pick.push(target);
                    }
                    break;
                }
            }
        }
        
        return result;
    }
}