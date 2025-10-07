import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] memo = new int[41][2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] result = fibCount(n);
            bw.write(result[0] + " " + result[1] + "\n");
        }
        bw.flush();
    }

    static int[] fibCount(int n) {
        if (memo[n][0] != 0 || memo[n][1] != 0) return memo[n];

        int[] a = fibCount(n - 1);
        int[] b = fibCount(n - 2);
        memo[n][0] = a[0] + b[0];
        memo[n][1] = a[1] + b[1];

        return memo[n];
    }
}