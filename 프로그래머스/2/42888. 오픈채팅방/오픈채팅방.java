import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        HashMap<String, String> userMap = new HashMap<>();
        String id, nickName;
        
        for (int i = 0; i < record.length; i++) {
            if (record[i].startsWith("Enter") || record[i].startsWith("Change")) {
                id = record[i].split(" ")[1];
                nickName = record[i].split(" ")[2];
                userMap.put(id, nickName);
            }
        }
        
        for (int i = 0; i < record.length; i++) {
            
            id = record[i].split(" ")[1];
            nickName = userMap.get(id);
            
            if (record[i].startsWith("Enter")) {
                answer.add(nickName + "님이 들어왔습니다.");
            } else if (record[i].startsWith("Leave")) {
                answer.add(nickName + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}