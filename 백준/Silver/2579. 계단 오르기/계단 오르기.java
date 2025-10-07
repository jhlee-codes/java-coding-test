import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] steps;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계단의 수
        int T = Integer.parseInt(br.readLine());

        steps = new int[T];

        for (int i = 0; i < T; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        // 각 계단까지의 최대 합
        dp = new int[T];
        Arrays.fill(dp, -1);

        System.out.println(dp(T - 1));
    }

    static int dp(int n) {
        // 기저 사례
        if (n == 0) return dp[0] = steps[0];
        if (n == 1) return dp[1] = steps[0] + steps[1];
        if (n == 2) return dp[2] = Math.max(steps[0] + steps[2], steps[1] + steps[2]);

        if (dp[n] != -1) return dp[n];

        // n번째 계단에 도착하는 방법은 두 가지
        // 1. n-2번째 계단에서 한 번에 n번째 계단
        // 2. n-1번째 계단에서 n번째 계단
        dp[n] = Math.max(dp(n-2) + steps[n], dp(n - 3) + steps[n-1] + steps[n]);
        return dp[n];
    }
}