import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> pastWords = new HashSet<>();
        pastWords.add(words[0]);
        char last = words[0].charAt(words[0].length() - 1);
        
        for (int i = 1; i < words.length; i++) {
            String currWord = words[i];
            char curr = currWord.charAt(0);

            // 탈락 조건 : 한글자 or 중복 or 끝문자가 다름
            if (currWord.length() == 1 || pastWords.contains(currWord) || curr != last) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
            
            pastWords.add(currWord);
            last = currWord.charAt(currWord.length() - 1);
        }
        
        return new int[] {0, 0};
    }
}