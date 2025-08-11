import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int groupWordCnt = 0;

        for (int i = 0; i < cnt; i++) {
            String word = br.readLine();
            boolean isGroupWord = true;

            // 현재 문자에서 달라지는 지점을 기준으로 문자열을 나눔
            // 뒷 문자열에 현재 문자가 포함되어 있으면 그룹단어 X
            for (int j = 0; j < word.length() - 1; j++) {
                if (word.charAt(j) != word.charAt(j+1)) {
                    String target = word.substring(j+1);
                    if (target.indexOf(word.charAt(j)) >= 0) {
                        isGroupWord = false;
                        break;
                    }
                }
            }

            if (isGroupWord) {
                groupWordCnt ++;
            }
        }

        System.out.println(groupWordCnt);
    }
}