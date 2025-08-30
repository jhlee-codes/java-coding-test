import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

    // 문제 : 단어에서 가장 많이 사용된 알파벳 찾기 (대소문자 구분 X)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char target = word.charAt(i);
            charMap.put(target, charMap.getOrDefault(target, 0) + 1);
        }

        int maxCnt = Collections.max(charMap.values());
        char result = '?';
        int cnt = 0;

        for (Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() == maxCnt) {
                result = entry.getKey();
                cnt++;
                if (cnt > 1) {
                    result = '?';
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
