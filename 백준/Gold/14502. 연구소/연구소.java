import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // 방향: 상하좌우
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static int n, m, result;
    static int[][] lab;

    // 문제: 연구소
    // - 벽 3개를 세우는 모든 조합을 탐색 (n,m의 범위가 작아서 완전탐색 가능)
    // - 바이러스는 상하좌우로 인접한 빈 칸으로 퍼짐
    // - 벽을 세운 후, 바이러스가 퍼진 후의 안전 영역 크기를 계산
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n: 세로, m: 가로
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 연구소 맵
        lab = new int[n][m];

        // 빈 칸 위치
        List<int[]> emptySpaces = new ArrayList<>();
        // 바이러스 위치
        List<int[]> virusPositions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                } else if (lab[i][j] == 2) {
                    virusPositions.add(new int[]{i, j});
                }
            }
        }

        result = 0;
        int emptyCount = emptySpaces.size();

        // 벽 3개를 세우는 모든 조합 탐색
        for (int i = 0; i < emptyCount; i++) {
            for (int j = i + 1; j < emptyCount; j++) {
                for (int k = j + 1; k < emptyCount; k++) {

                    // 연구소 맵 복사 (원본 보존)
                    int[][] board = copy(lab);

                    // 벽 3개 세우기
                    int[] wall1 = emptySpaces.get(i);
                    int[] wall2 = emptySpaces.get(j);
                    int[] wall3 = emptySpaces.get(k);
                    board[wall1[0]][wall1[1]] = 1;
                    board[wall2[0]][wall2[1]] = 1;
                    board[wall3[0]][wall3[1]] = 1;

                    // 바이러스 퍼뜨리기
                    spread(board, virusPositions);

                    // 안전 영역 크기 계산
                    int safeArea = countSafe(board);
                    if (safeArea > result) {
                        result = safeArea;
                    }
                }
            }
        }

        System.out.println(result);
    }

    static void spread(int[][] board, List<int[]> virusPositions) {
        
        ArrayDeque<int[]> q = new ArrayDeque<>(virusPositions);
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                // 범위 내이고 빈 칸이라면 바이러스 퍼짐
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == 0) {
                    board[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    static int countSafe(int[][] board) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static int[][] copy(int[][] original) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, m);
        }
        return copy;
    }
}
