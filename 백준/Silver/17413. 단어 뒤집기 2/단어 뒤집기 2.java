import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 문제 : 문자열 뒤집기
    // 태그는 그대로, 그 외의 단어는 거꾸로
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder current = new StringBuilder();
        boolean isTag = false;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '<') {
                sb.append(current.reverse());
                current.setLength(0);
                isTag = true;
                sb.append(ch);
            } else if (ch == '>') {
                isTag = false;
                sb.append(ch);
            } else if (isTag) {
                sb.append(ch);
            } else {
                if (ch == ' ') {
                    sb.append(current.reverse());
                    current.setLength(0);
                    sb.append(' ');
                } else {
                    current.append(ch);
                }
            }
        }

        sb.append(current.reverse());

        System.out.println(sb);
    }
}