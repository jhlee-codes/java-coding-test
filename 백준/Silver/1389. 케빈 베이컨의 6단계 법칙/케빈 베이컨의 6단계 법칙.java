
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] g;
    static int N, M;

    // 문제 : 케빈 베이컨의 6단계 법칙
    // 케빈 베이컨의 수가 가장 작은 사람 출력 (여러명일 경우에는 번호가 가장 작은 사람 출력)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        int answer = 1;
        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (sum < result) {
                result = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    // 시작점에서 모든 사람까지의 최단거리 합
    public static int bfs(int num) {

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        dist[num] = 0;
        queue.offer(num);

        while(!queue.isEmpty()){
            int target = queue.poll();

            for (int next : g[target]) {
                if (dist[next] == -1){
                    dist[next] = dist[target] + 1;
                    queue.offer(next);
                }
            }
        }

        int sum = 0;
        for (Integer next : dist) {
            sum += next;
        }
        return sum;
    }
}