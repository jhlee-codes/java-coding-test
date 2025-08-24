import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int recursiveCnt = 0;
    public static int dpCnt = 0;

    // 문제 : 코드1, 코드2의 실행횟수 출력
    // 입력 : 숫자 n
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        recursive(N);
        dp(N);

        System.out.print(recursiveCnt + " " + dpCnt);
    }

    /** 피보나치 재귀호출 의사코드
     * fib(n) {
     *     if (n = 1 or n = 2)
     *     then return 1;  # 코드1
     *     else return (fib(n - 1) + fib(n - 2));
     * }
     */
    public static int recursive(int n) {

        if (n == 1 || n == 2) {
            recursiveCnt += 1;
            return 1;
        }

        return recursive(n - 1) + recursive(n - 2);
    }

    /** 피보나치 동적계획법 의사코드
     * fibonacci(n) {
     *     f[1] <- f[2] <- 1;
     *     for i <- 3 to n
     *         f[i] <- f[i - 1] + f[i - 2];  # 코드2
     *     return f[n];
     * }
     */
    public static int dp(int n) {

        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            dpCnt += 1;
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n - 1];
    }
}
