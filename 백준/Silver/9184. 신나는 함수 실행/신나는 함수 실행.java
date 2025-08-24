import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][][] arr = new int[21][21][21];


    // 문제 : a, b, c가 주어졌을 때, w(a, b, c)를 출력
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue;

            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            sb.append(String.format("w("+a+", "+b+", "+c+")"+" = " + w(a, b, c))).append('\n');
        }

        System.out.println(sb);
    }

    /**
     * if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
     *     1
     *
     * if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
     *     w(20, 20, 20)
     *
     * if a < b and b < c, then w(a, b, c) returns:
     *     w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
     *
     * otherwise it returns:
     *     w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
     */
    public static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (arr[a][b][c] != 0) {
            return arr[a][b][c];
        }

        if (a < b && b < c) {
            arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return arr[a][b][c];
    }
}
