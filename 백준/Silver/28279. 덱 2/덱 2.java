import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i=0;i<num;i++) {
            int command = sc.nextInt();
            int target = 0;
            if (command == 1 || command == 2) {
                target = sc.nextInt();
            }
            switch (command) {
                case 1:
                    deque.offerFirst(target);
                    break;
                case 2:
                    deque.offerLast(target);
                    break;
                case 3:
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollFirst() + "\n");
                    }
                    break;
                case 4:
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollLast() + "\n");
                    }
                    break;
                case 5:
                    bw.write(deque.size()+"\n");
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case 7:
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.getFirst()+"\n");
                    }
                    break;
                case 8:
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.getLast()+"\n");
                    }
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
        sc.close();
    }
}