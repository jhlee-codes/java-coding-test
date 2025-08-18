import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int[] powerList = new int[total];
        // 각 인덱스까지의 비증가 부분수열의 최대 길이
        int[] dp = new int[total];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            powerList[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 비증가 부분수열 길이
        int maxLength = 0;
        for (int i = 0; i < total; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 앞 원소 >= 현재 원소이면 길이를 +1함
                if (powerList[j] > powerList[i]) {
                    // 가장 긴 길이 선택
                    dp[i] = max(dp[i], dp[j] + 1); 
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        // 최소 제거 개수
        System.out.println(total - maxLength);
    }
}