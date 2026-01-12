import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peekLast() <= height) {
                stack.pollLast();
            }
            sum += stack.size();
            stack.addLast(height);
        }

        System.out.println(sum);
    }
}
