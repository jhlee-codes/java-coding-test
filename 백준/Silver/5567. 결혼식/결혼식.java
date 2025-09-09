import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] g;

    // 문제 : 상근이의 결혼식에 초대하는 동기의 수
    // 결혼식 초대 조건 : 친구, 친구의 친구 (상근 : 1)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            // a와 b는 친구관계
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());

            g[a].add(b);
            g[b].add(a);
        }

        System.out.println(bfs(1));
    }

    static int bfs(int x) {

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(x);
        dist[x] = 0;

        while (!q.isEmpty()) {
            int t = q.poll();
            if (dist[t] == 3) continue;
            for (int y : g[t]) {
                if (dist[y] != -1) continue;
                dist[y] = dist[t] + 1;
                q.offer(y);
            }
        }

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (dist[i] == 1 || dist[i] ==2) {
                cnt++;
            }
        }
        return cnt;
    }
}
