import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] height = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans =  new int[n];
        Arrays.fill(ans, 0);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 현재 탑(height[i])보다 작거나 같은 탑은
            // 현재 탑의 "왼쪽에서 더 큰 탑" 후보가 될 수 없으므로 스택에서 제거
            while (!stack.isEmpty() && height[stack.peekLast()] <= height[i]) {
                stack.pollLast();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peekLast() + 1;

            // 현재 탑 i를 이후 오른쪽 탑들의 후보로 스택에 넣어둠
            stack.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
