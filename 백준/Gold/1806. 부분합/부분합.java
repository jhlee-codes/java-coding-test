import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열의 길이 n, 부분합 최소값 s
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        // 수열 arr
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 배열
        long[] sum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }

        // 투 포인터 활용 (누적합 인덱스)
        // ans: 최소 길이
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;

        while (l <= n && r <= n) {
            // 구간합 계산
            long cur = sum[r] - sum[l];
            if (cur >= s) {
                ans = Math.min(ans, r - l);
                l++;
            } else {
                r++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}