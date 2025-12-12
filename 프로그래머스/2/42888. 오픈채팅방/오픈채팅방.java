import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        HashMap<String, String> userMap = new HashMap<>();
        
        for (int i = 0; i < record.length; i++) {
            String id, nickName;
            String[] parts = record[i].split(" ");
            
            if (parts[0].equals("Enter") || parts[0].equals("Change")) {
                id = parts[1];
                nickName = parts[2];
                userMap.put(id, nickName);
            }
        }
        
        for (int i = 0; i < record.length; i++) {
            String id, nickName;
            String[] parts = record[i].split(" ");
            id = parts[1];
            nickName = userMap.get(id);
            
            if (parts[0].equals("Enter")) {
                answer.add(nickName + "님이 들어왔습니다.");
            } else if (parts[0].equals("Leave")) {
                answer.add(nickName + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}