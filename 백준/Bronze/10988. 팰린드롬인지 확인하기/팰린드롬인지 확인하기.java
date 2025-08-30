import java.io.*;

public class Main {

    // 문제 : 팰린드롬인지 확인하기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int result = 1;
        for (int i = 0; i < word.length(); i++) {
            char currentC = word.charAt(i);
            char reverseC = word.charAt(word.length() - 1 - i);

            if (currentC != reverseC) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
}