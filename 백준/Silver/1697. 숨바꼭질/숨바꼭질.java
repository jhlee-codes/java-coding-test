import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수빈 위치
        int K = Integer.parseInt(st.nextToken());   // 동생 위치

        final int MAX = 100000;
        boolean[] visited = new boolean[MAX + 1];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 가장 빠른 시간
        int fastTime = 0;

        queue.offer(N);
        visited[N] = true;

        while(!queue.isEmpty()) {
            // 같은 레벨 노드 = 하나의 큐 단위
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int target = queue.poll();

                // 목표 지점 도달시, 시간 출력
                if (target == K) {
                    System.out.println(fastTime);
                    break;
                }

                int[] next = {target - 1, target + 1, target * 2};

                for (int nx : next) {
                    if (nx < 0 || nx > MAX || visited[nx]) {
                        continue;
                    }
                    visited[nx] = true;
                    queue.offer(nx);
                }
            }
            // 같은 레벨의 노드 처리 후 시간 + 1
            fastTime ++;
        }
    }
}