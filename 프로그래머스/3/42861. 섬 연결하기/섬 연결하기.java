import java.util.*;

class Solution {
    
    public class Edge {
        int idx;
        int w;
        
        public Edge(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }

    public int solution(int n, int[][] costs) {

        // 인접 리스트 구성
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] e : costs) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            // u -> v, v -> u 추가
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));    // 후보 간선들 (최소 힙)
        
        int total = 0;  // 총 비용
        int visitedCnt = 1; // 0번 섬 방문처리
        visited[0] = true;
        for (Edge e : graph[0]) pq.add(e);
        
        while (!pq.isEmpty() && visitedCnt < n) {
            Edge cur = pq.poll();
            
            if (visited[cur.idx]) continue;
            
            visited[cur.idx] = true;
            total += cur.w;
            visitedCnt++;
            
            // 새로 포함된 섬에서 바깥으로 나가는 후보 간선들 추가
            for (Edge next : graph[cur.idx]) {
                if (!visited[next.idx]) pq.add(next);
            }
        }
        
        return total;
    }
}