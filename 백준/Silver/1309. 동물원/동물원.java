import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 문제 : 2 * n 우리에 사자를 배치하는 경우의 수
    // 틀린 이유 : 중간 계산에서 모듈러 연산을 안함 -> int 오버플로우
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int mod = 9901;

        // [i][0] : 비움 / [i][1] : 왼쪽 / [i][2] : 오른쪽
        int[][] dp = new int[N +1][3];

        // 초기값 설정
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = ((dp[i - 1][0] + dp[i - 1][1]) % mod + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % mod;
        System.out.println(result);
    }
}
