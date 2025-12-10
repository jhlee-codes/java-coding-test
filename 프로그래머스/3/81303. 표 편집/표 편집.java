import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 삭제된 행을 저장할 스택
        Stack<Integer> deleted = new Stack<>();
        
        // 현재 인덱스 기준으로 위, 아래 행 위치 (양방향 연결리스트)
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        k++;
        
        for (int i = 0; i < cmd.length; i++) {
            String[] parts = cmd[i].split(" ");
            String target = parts[0];
            int num = 0;
            if (parts.length > 1) {
                num = Integer.parseInt(parts[1]);
            }

            switch (target) {
                case "U":
                    // 현재 선택된 행 k에서 위로 num칸 이동
                    for (int j = 0; j < num; j++) {
                        k = up[k];
                    }
                    break;
                case "D":
                    // 현재 선택된 행 k에서 아래로 num칸 이동
                    for (int j = 0; j < num; j++) {
                        k = down[k];
                    }
                    break;
                case "C":
                    deleted.push(k);
                    // k의 위/아래 이웃 끼리 연결해서 k를 연결에서 분리
                    up[down[k]] = up[k];
                    down[up[k]] = down[k];
                    // 삭제된 행이 가장 마지막 행인 경우 바로 윗 행 선택
                    k = n < down[k] ? up[k] : down[k];
                    break;
                case "Z":
                    int restore = deleted.pop();
                    // restore의 위/아래 이웃을 다시 restore와 연결
                    down[up[restore]] = restore;
                    up[down[restore]] = restore;
                    break;
                default:
                    break;
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for (int i : deleted) {
            answer[i - 1] = 'X';
        }
        
        return new String(answer);
    }
}