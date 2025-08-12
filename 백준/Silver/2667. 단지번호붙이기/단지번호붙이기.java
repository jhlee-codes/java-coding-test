import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int size = Integer.parseInt(br.readLine());
       int[][] maps =  new int[size][size];
       boolean[][] visited = new boolean[size][size];
       List<Integer> houseCntList = new ArrayList<>();
       int apartmentCnt = 0;

       for (int i = 0; i < size; i++) {
           String line = br.readLine();
           for (int j = 0; j < size; j++) {
               maps[i][j] = line.charAt(j) - '0';
           }
       }

       for (int i = 0; i < size; i++) {
           for  (int j = 0; j < size; j++) {
               // 시작점
               if (maps[i][j] == 1 && !visited[i][j]) {
                   houseCntList.add(dfs(i, j, visited, maps));
                   apartmentCnt++;
               }
           }
       }

       // 오름차순 정렬
       Collections.sort(houseCntList);

       System.out.println(apartmentCnt);
       for (int cnt : houseCntList) {
           System.out.println(cnt);
       }
    }

    public static int dfs(int x, int y, boolean[][] visited, int[][] maps) {

        // 값 범위를 초과 or 이미 방문 or 0일 경우 패스
        if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length
            || visited[x][y] || maps[x][y] == 0) {
            return 0;
        }

        int result = 1;
        visited[x][y] = true;

        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for (int k = 0; k < 4; k++) {
            int dx = x + dir[k][0];
            int dy = y + dir[k][1];

            result += dfs(dx, dy, visited, maps);
        }

        return result;
    }
}