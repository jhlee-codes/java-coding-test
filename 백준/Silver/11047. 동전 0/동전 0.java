import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coinArr = new int[n];

        int result = 0;
        int remain = k;

        for (int i = 0; i < n; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }

        // 가장 큰 동전부터 처리
        for (int i = n - 1; i >= 0; i--) {
            if (remain == 0) break;
            int coin = coinArr[i];
            // 필요한 동전 개수 = 남은 금액 / 동전
            int m = remain / coin;
            result += m;
            // 남은 금액 차감
            remain -= m * coin;
        }

        System.out.println(result);
    }
}