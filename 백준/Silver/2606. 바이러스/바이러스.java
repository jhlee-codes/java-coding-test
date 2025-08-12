import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 출력 : 웜 바이러스에 걸리게 되는 컴퓨터의 수
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int linkedPairCnt =  Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[total+1];
        // 연결된 컴퓨터 번호 배열
        int[][] adjList = new int[linkedPairCnt][2];
        int resultCnt = 0;

        for (int i = 0; i < linkedPairCnt; i++) {
            st = new StringTokenizer(br.readLine());
            adjList[i][0] = Integer.parseInt(st.nextToken());
            adjList[i][1] = Integer.parseInt(st.nextToken());
        }

        resultCnt += dfs(1, visited, adjList);
        System.out.println(resultCnt-1);    // 1번 컴퓨터 제외
    }

    public static int dfs(int x, boolean[] visited, int[][] adjList) {

        if (visited[x]) {
            return 0;
        }

        visited[x] = true;
        int cnt = 1;

        // 인접한 노드 찾기
        for (int i = 0; i < adjList.length; i++) {
            // 양방향 점검
            if (adjList[i][0] == x) {
                cnt += dfs(adjList[i][1], visited, adjList);
            } else if (adjList[i][1] == x) {
                cnt += dfs(adjList[i][0], visited, adjList);
            }
        }
        return cnt;
    }
}