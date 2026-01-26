import java.util.*;

class Solution {
    
    int result = 0;
    List<Integer>[] child;
    int[] info;
    
    public int solution(int[] info, int[][] edges) {
        
        this.info = info;
        int n = info.length;
        child = new ArrayList[n];
        
        for (int i = 0; i < n; i++) child[i] = new ArrayList<>();
        
        for (int[] e : edges) {
            child[e[0]].add(e[1]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        candidates.addAll(child[0]);

        dfs(1, 0, candidates);
        
        return result;
    }
    
    private void dfs(int sheep, int wolf, List<Integer> candidates) {
        if (wolf >= sheep) return;
        
        result = Math.max(result, sheep);
        
        for (int i = 0; i < candidates.size(); i++) {
            
            int next = candidates.get(i);
            
            int s = sheep + (info[next] == 0 ? 1 : 0);
            int w = wolf + (info[next] == 0 ? 0 : 1);
            
            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(i);
            nextCandidates.addAll(child[next]);
        
            dfs(s, w, nextCandidates);
        }
    }
}