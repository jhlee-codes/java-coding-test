import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 괄호
        int num = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            stack.clear();
            Boolean isVps = true;
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) =='(') {
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        isVps = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                isVps = false;
            }

            bw.write(isVps ? "YES" : "NO");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}