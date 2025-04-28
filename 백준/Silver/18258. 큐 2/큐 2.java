import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Queue<Integer> numQueue = new LinkedList<>();
        int lastNum = 0;

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");

            switch (strArr[0]) {
                case "push" :
                    int n = Integer.parseInt(strArr[1]);
                    lastNum = n;
                    numQueue.offer(n);
                    break;
                case "pop" :
                    if (numQueue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(numQueue.poll()+"\n");
                    }
                    break;
                case "size" :
                    bw.write(numQueue.size()+"\n");
                    break;
                case "empty" :
                    if (numQueue.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front" :
                    if (numQueue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(numQueue.peek()+"\n");
                    }
                    break;
                case "back" :
                    if (numQueue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(lastNum+"\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
}