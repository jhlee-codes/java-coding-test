import java.util.*;

class Solution {
    
    public class Music {
        private String genre;
        private int id;
        private int played;
        
        public Music(String genre, int id, int played) {
            this.genre = genre;
            this.id = id;
            this.played = played;
        }
    
        public String getGenre() {
            return genre;   
        }
        
        public int getId() {
            return id;
        }
        
        public int getPlayed() {
            return played;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생수
        Map<String, Integer> total = new HashMap<>();
        // 장르별 곡 리스트
        Map<String, List<Music>> byGenre = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
        
            total.put(genre, total.getOrDefault(genre, 0) + play);
            byGenre.computeIfAbsent(genre, k -> new ArrayList<>())
                .add(new Music(genre, i, play));
        }
        
        // 장르 정렬
        List<String> genreOrder = new ArrayList<>(total.keySet());
        genreOrder.sort((a,b) -> total.get(b).compareTo(total.get(a)));
        
        // 노래 정렬
        Comparator<Music> songOrder = 
            Comparator.comparingInt(Music::getPlayed).reversed()
            .thenComparingInt(Music::getId);
        
        List<Integer> album = new ArrayList<>();
        
        for (String genre : genreOrder) {
            
            List<Music> list = byGenre.get(genre);
            list.sort(songOrder);
            
            album.add(list.get(0).getId());
            if (list.size() > 1) album.add(list.get(1).getId());
        }
        
        int[] answer = new int[album.size()];
        for (int i = 0; i < album.size(); i++) answer[i] = album.get(i);
        return answer;
    }
}