import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> album = new ArrayList<>();
        // {장르 : 총재생횟수}
        Map<String, Integer> genresMap = new HashMap<>();
        //{장르 : {노래 고유번호 : 재생횟수}
        Map<String, Map<Integer, Integer>> playsMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
            playsMap.computeIfAbsent(genres[i], k -> new HashMap<>())
                    .put(i, plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(genresMap.keySet());
        
        // 장르 정렬
        keySet.sort((o1, o2) -> genresMap.get(o2).compareTo(genresMap.get(o1)));
        
        for (String key : keySet) {
            
            Map<Integer, Integer> inner = playsMap.get(key);
            // 노래 정렬
            List<Map.Entry<Integer, Integer>> songs = new ArrayList<>(inner.entrySet());
            
            songs.sort((e1, e2) -> {
                  int cmp = e2.getValue().compareTo(e1.getValue());
                  if (cmp != 0) return cmp;
                  return e1.getKey().compareTo(e2.getKey());
            });
            
            album.add(songs.get(0).getKey());
            if (songs.size() > 1) album.add(songs.get(1).getKey());    
        }
        
        int[] answer = new int[album.size()];
        for (int i = 0; i < album.size(); i++) answer[i] = album.get(i);
        return answer;
    }
}