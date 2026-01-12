import java.io.*;
import java.util.*;

// 오큰수: 오른쪽에 있으면서 A보다 큰 수 중에서 가장 왼쪽에 있는 수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오큰수 배열
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 인덱스 스택 (오큰수를 못찾은 원소의 위치)
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] < arr[i]) {
                ans[stack.pollLast()] = arr[i];
            }
            stack.addLast(i);
        }

        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}