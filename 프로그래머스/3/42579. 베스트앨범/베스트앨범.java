import java.util.*;
import java.util.stream.Collectors;

class Solution {

    static class GenreInfo {
        int totalPlays = 0;
        List<Music> musicList = new ArrayList<>();
        
        public void updatePlays(int plays) {
            this.totalPlays += plays;
        }
        
        public void addMusic(Music m) {
            this.musicList.add(m);
        }
    }
    
    static class Music {
        int idx;
        int plays;
        
        public Music(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        // {장르 : 장르정보(총 재생횟수 + 노래목록)}
        Map<String, GenreInfo> genreMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            
            GenreInfo gi = genreMap.computeIfAbsent(g, k -> new GenreInfo());
            gi.updatePlays(p);
            gi.addMusic(new Music(i, p));
        }
        
        // 장르 정렬 (총 재생횟수 내림차순)
        List<String> sortedGenre = genreMap.entrySet().stream()
            .sorted((e1, e2) -> Integer.compare(e2.getValue().totalPlays, e1.getValue().totalPlays))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        // 각 장르에서 상위 2곡 뽑아 결과에 저장
        for (String g : sortedGenre) {
            // 장르별 노래 정렬 (1. 재생횟수 내림차순 2. 인덱스 오름차순)
            List<Integer> sortedSongs = genreMap.get(g).musicList.stream()
                .sorted((e1, e2) -> {
                    int cmp = Integer.compare(e2.plays, e1.plays);
                    if (cmp != 0) return cmp;
                    return Integer.compare(e1.idx, e2.idx);
                })
                .limit(2)
                .map(m -> m.idx)
                .collect(Collectors.toList());
            
            // 결과에 값 추가
            result.addAll(sortedSongs);
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}