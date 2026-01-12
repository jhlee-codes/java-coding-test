import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                sb.append(ch);

            } else if (ch == '(') {
                stack.addLast(ch);

            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peekLast() != '(') {
                    sb.append(stack.pollLast());
                }
                stack.pollLast(); // '(' 제거

            } else { // 연산자
                while (!stack.isEmpty()
                    && stack.peekLast() != '('
                    && prec(stack.peekLast()) >= prec(ch)) {
                    sb.append(stack.pollLast());
                }
                stack.addLast(ch);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pollLast());
        System.out.println(sb);
    }

    static int prec(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }
}
