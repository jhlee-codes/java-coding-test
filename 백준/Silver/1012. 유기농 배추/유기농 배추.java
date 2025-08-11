import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());

        // 테스트 케이스 수 만큼 반복
        for (int i = 0; i < total; i++) {
            sb.append(getEarthwormCnt()).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static int getEarthwormCnt() throws IOException {

        // 차례대로 배추밭의 가로, 세로, 배추 개수
        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        int[][] farm = new int[height][width];
        boolean[][] visited = new boolean[height][width];

        // 배추흰지렁이 수
        int earthwormCnt = 0;

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            farm[y][x] = 1;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (farm[i][j] == 1 && !visited[i][j]) {
                    // 시작점
                    bfs(i, j, visited, farm);
                    earthwormCnt++;
                }
            }
        }
        return earthwormCnt;
    }

    public static void bfs(int y, int x, boolean[][] visited, int[][] farm) {
        // BFS : 큐 활용
        int height = farm.length;
        int width = farm[0].length;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[y][x] = true;
        queue.offer(new int[]{y, x});

        int [][] dir = {{1,0}, {-1,0}, {0,-1}, {0,1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int a = cur[0];
            int b = cur[1];

            // 상하좌우를 돌며 1일 경우, 방문처리
            for (int[] d : dir) {
                int ny = a + d[0];
                int nx = b + d[1];

                if (ny >= 0 && ny < height && nx >= 0 && nx < width
                    && !visited[ny][nx] && farm[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}