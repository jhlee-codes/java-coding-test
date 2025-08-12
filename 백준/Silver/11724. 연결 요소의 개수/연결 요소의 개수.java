import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 출력 : 연결 요소의 개수
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] adgeList = new int[m][2];
        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int linkedCnt = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            adgeList[i][0] = Integer.parseInt(st.nextToken());
            adgeList[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                // 인접된 노드 찾기
                for (int[] adge : adgeList) {
                    if (adge[0] == cur && !visited[adge[1]]) {
                        visited[adge[1]] = true;
                        queue.offer(adge[1]);
                    } else if (adge[1] == cur && !visited[adge[0]]) {
                        visited[adge[0]] = true;
                        queue.offer(adge[0]);
                    }
                }
            }
            // 연결요소 개수 +1
            linkedCnt++;
        }
        System.out.println(linkedCnt);
    }
}