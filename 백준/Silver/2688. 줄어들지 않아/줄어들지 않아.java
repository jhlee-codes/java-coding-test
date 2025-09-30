import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 문제: 줄어들지 않는 n자리 수의 개수
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            // 맨 마지막 숫자는 0~9까지 가능
            // 그 이전 숫자는 마지막 숫자보다 작거나 같아야 함
            // ex. 길이 3, 끝이 2 -> 002, 012, 022, 112, 122, 222
            // 즉, 끝이 2인 3자리 수의 개수는 끝이 0, 1, 2인 2자리 수의 개수의 합과 같음
            // dp[i][j] = i자리 수에서 끝자리가 j인 수의 개수
            // dp[i][j] = dp[i-1][0] + dp[i-1][1] + ... + dp[i-1][j]

            long[][] dp = new long[n + 1][10];

            // 초기값 설정: 1자리 수는 각 숫자 하나씩
            for (int j = 0; j < 10; j++) {
                dp[1][j] = 1;
            }

            // dp[i][j] = dp[i-1][0] + dp[i-1][1] + ... + dp[i-1][j]
            for (int j = 2; j <= n; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int m = 0; m <= k; m++) {
                        dp[j][k] += dp[j - 1][m];
                    }
                }
            }

            long result = 0;
            for (int j = 0; j < 10; j++) {
                result += dp[n][j];
            }

            System.out.println(result);
        }
    }
}