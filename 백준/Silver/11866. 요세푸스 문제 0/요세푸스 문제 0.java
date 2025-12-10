import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();

        // 큐 초기화
        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }

        while (!q.isEmpty()) {

            // 앞에서부터 뺀 숫자를 뒤에 다시 삽입 (원형 큐)
            for (int j = 0; j < k - 1; j++) {
                q.add(q.poll());
            }

            list.add(q.poll());
        }

        bw.write("<");

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).toString());
            if (i != list.size() - 1) {
                bw.write(", ");
            }
        }

        bw.write(">");

        bw.flush();
    }
}
