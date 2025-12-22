import java.util.*;

class Solution {
    
    private int bestCnt = 0;
    private int[] info;
    private Map<Integer, List<Integer>> pasture;
    
    public int solution(int[] info, int[][] edges) {
        
        this.info = info;
        pasture = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            pasture.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
    
        List<Integer> candidates = new ArrayList<>();
        candidates.addAll(pasture.getOrDefault(0, Collections.emptyList()));
        
        // 루트 노드는 항상 양(0)
        bestCnt = 1;
        dfs(1, 0, candidates, visited);
    
        return bestCnt;
    }
    
    private void dfs(int sheep, int wolf, List<Integer> candidates, boolean[] visited) {
        
        bestCnt = Math.max(bestCnt, sheep);
        
        for (int i = 0; i < candidates.size(); i++) {
            int nxt = candidates.get(i);
            
            boolean[] nextVisited = visited.clone();
            nextVisited[nxt] = true;
            
            int nextSheep = sheep + (info[nxt] == 0 ? 1 : 0);
            int nextWolf  = wolf  + (info[nxt] == 1 ? 1 : 0);
            
            if (nextWolf >= nextSheep) continue;
            
            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(i);
            
            for (int child : pasture.getOrDefault(nxt, Collections.emptyList())) {
                if (!nextVisited[child]) nextCandidates.add(child);
            }
            
            dfs(nextSheep, nextWolf, nextCandidates, nextVisited);
        }
    }
}