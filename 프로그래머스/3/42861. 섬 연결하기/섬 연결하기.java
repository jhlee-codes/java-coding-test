import java.util.*;
// 모범답안
class Solution {
    
    private static int[] parent;
    
    private static int find(int x) {
        if (parent[x] == x) return x;
        // 경로 압축: x의 부모를 루트로 설정
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
    
    public int solution(int n, int[][] costs) {
        
        // 비용 기준 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        // parent 배열 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int edges = 0;
        
        for (int[] edge : costs) {
            // n - 1개의 다리가 연결된 경우 모든 섬이 연결됨
            if (edges == n - 1) break;
            
            // 현재 연결하려는 두 섬이 이미 연결되어 있는지 확인
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }    
        
        return answer;
    }
}