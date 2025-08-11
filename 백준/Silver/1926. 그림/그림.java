import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] paints = new int[height][width];
        boolean[][] visited = new boolean[height][width];

        int paintCnt = 0;
        int maxPaintArea = 0;
 
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                paints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (paints[i][j] == 1 && !visited[i][j]) {
                    // 그림의 시작점
                    int area = dfs(i, j, visited, paints);
                    paintCnt++;
                    maxPaintArea = Math.max(maxPaintArea, area);
                }
            }
        }

        System.out.println(paintCnt);
        System.out.println(maxPaintArea);
    }

    public static int dfs(int x, int y, boolean[][] visited, int[][] paints) {
        // DFS : 재귀 함수 활용
        if (x < 0 || x >= paints.length || y < 0 || y >= paints[0].length) {
            return 0;
        }
        // 이미 방문했거나 0이면 무효
        if (visited[x][y] || paints[x][y] == 0) {
            return 0;
        }
        // 방문 처리, 기본 넓이 1로 설정
        visited[x][y] = true;
        int area = 1;
        // 인접한 노드(상,하,좌,우)를 거치며 넓이 누적
        area += dfs(x, y+1, visited, paints);
        area += dfs(x, y-1, visited, paints);
        area += dfs(x-1, y, visited, paints);
        area += dfs(x+1, y, visited, paints);

        return area;
    }
}