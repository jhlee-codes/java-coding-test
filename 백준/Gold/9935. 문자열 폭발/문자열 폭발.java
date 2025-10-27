import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 문제: 문자열 폭발
    // 모든 폭발이 끝난 후에 남는 문자열 출력
    // 자료구조: 스택
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        int n = str.length();
        int m = bomb.length();
        StringBuilder sb = new StringBuilder();
        char last = bomb.charAt(m - 1);

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            sb.append(c);

            if (c == last && sb.length() >= m) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    // sb의 마지막 m 글자와 bomb 문자열을 비교
                    if (sb.charAt(sb.length() - m + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    // 폭발 문자열 제거
                    sb.setLength(sb.length() - m);
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
