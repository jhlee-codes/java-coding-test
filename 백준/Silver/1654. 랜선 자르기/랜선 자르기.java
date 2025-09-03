
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 문제 : K개의 랜선 -> N개의 일정한 길이로 만들 수 있는 랜선의 최대 길이 구하기 (랜선 자르기)
    // 틀린 이유 : 정수 오버플로우 -> 랜선 길이의 최댓값 2^31, low + high = 2^31 (범위 초과)
    // int -> long으로 자료형 변경
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long[] cables = new long[K];
        long high = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
            high = Math.max(high, cables[i]);
        }

        long low = 1;
        long result = 0;

        // 이분 탐색: 랜선을 mid만큼 잘라가며 랜선 개수를 구함
        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;

            for (long len : cables) {
                cnt += (len / mid);
            }

            // cnt가 N보다 크거나 같으면 오른쪽 구간, 적으면 왼쪽 구간 탐색
            if (cnt >= N) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
