import java.util.*;

class Solution {

    // 다음 좌표 결정
    private static final HashMap<Character, int[]> location = new HashMap<>();
    
    private static void initLocation() {
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('R', new int[]{1,0});
        location.put('L', new int[]{-1,0});
    }
    
    public int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;
        HashSet<String> answer = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                continue;
            }
            
            // A -> B / B -> A 양방향 경로 모두 추가
            // x y nx ny -> (x,y) -> (nx,ny)로 이동했음을 뜻함
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            
            x = nx;
            y = ny;
        }
        
        return answer.size() / 2;
    }
}