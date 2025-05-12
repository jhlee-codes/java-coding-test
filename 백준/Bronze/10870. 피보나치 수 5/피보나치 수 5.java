import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        recursive(num, 0, 1,  0);
    }


    public static void recursive(int num, int N, int M, int current) {
        if (current == num) {
            System.out.println(N);
            return;
        }

        int sum = N + M;
        N = M;
        current += 1;
        recursive(num,N,sum, current);
    }
}
