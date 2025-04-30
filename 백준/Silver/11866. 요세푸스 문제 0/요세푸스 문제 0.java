import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<num;i++) {
            queue.add(i+1);
        }

        while (!queue.isEmpty()) {
            for (int i=1;i<target;i++) {
                queue.add(queue.poll());
            }
            list.add(queue.poll());
        }
        bw.write("<");
        for (int i=0;i<list.size();i++) {
            bw.write(String.valueOf(list.get(i)));
            if (i<list.size()-1) {
                bw.write(", ");
            }

        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
