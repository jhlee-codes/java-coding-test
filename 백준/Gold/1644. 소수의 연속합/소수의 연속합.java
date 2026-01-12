import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if (n < 2) {
            System.out.println(0);
            return;
        }

        // 소수 배열
        boolean[] isComposite = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }

        int cnt = 0;
        int l = 0, r = 0;
        long sum = 0;

        while (true) {
            if (sum >= n) {
                if (sum == n) cnt++;
                sum -= primes.get(l++);
            } else {
                if (r == primes.size()) break;
                sum += primes.get(r++);
            }
        }

        System.out.println(cnt);
    }
}