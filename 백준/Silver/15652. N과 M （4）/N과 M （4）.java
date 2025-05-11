import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public void recursive(int N, int M, Stack<Integer> selected, int current) {

        // 기저 사례
        if (current == M) {
            for (int i = 0; i < selected.size(); i++) {
                sb.append(selected.get(i)).append(" ");
            }
           sb.append("\n");
           return;
        }

        for (int i = 1; i <= N; i++) {
            if (!selected.isEmpty() && i < selected.get(selected.size()-1)) {
                continue;
            }
            selected.push(i);
            recursive(N, M, selected, current + 1);
            selected.pop();
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        recursive(N, M, new Stack<>(), 0);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}