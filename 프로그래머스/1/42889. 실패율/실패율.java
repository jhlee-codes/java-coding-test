import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        return getArr(N, stages);
    }
    
    public int[] getArr(int N, int[] stages) {
        
        // 스테이지별 실패율 배열
        Double[] failRateArr = new Double[N];
        // 스테이지 번호 구분용 실패율 배열 (깊은 복사)
        Double[] failRateStage = new Double[N];
        // 최종 결과 배열
        int[] result = new int[N];
        
        // 실패율 구하기
        for (int i=0; i<N; i++) {

            int challengerCnt = 0;
            int clearCnt = 0;
            int failerCnt =0;
            int stageNum = i + 1;
            
            for (int stage : stages) {
                if (stage >= stageNum) challengerCnt ++;
                if (stage > stageNum) clearCnt ++;
            }
            
            failerCnt = challengerCnt - clearCnt;
            failRateArr[i] = challengerCnt !=0 ? (double) failerCnt / challengerCnt : 0.0;
        }
        
        failRateStage = Arrays.copyOf(failRateArr, N);
        
        // 내림차순 정렬
        Arrays.sort(failRateArr, Collections.reverseOrder());
        
        boolean[] visited = new boolean[N];
        for (int i=0; i<failRateArr.length; i++) {
            for (int j=0; j<failRateStage.length; j++) {
                if (failRateArr[i] == failRateStage[j] && !visited[j]) {
                    result[i] = j+1;
                    visited[j] = true;
                    break;
                }
            }
        }
        
        return result;
    }
}