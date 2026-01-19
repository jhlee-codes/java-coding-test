import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> userMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] target = record[i].split(" ");
            String cmd = target[0];
            String userId = target[1];
            
            if (cmd.equals("Leave")) continue;
            
            String name = target[2];
            
            switch (cmd) {
                case "Enter":
                    userMap.put(userId, name);
                    break;
                case "Change":
                    userMap.put(userId, name);
                    break;
            }
        }
        
        for (String str : record) {
            String[] target = str.split(" ");
            String cmd = target[0];
            String userId = target[1];
            String name = userMap.get(userId);
            
            switch (cmd) {
                case "Enter":
                    result.add(name + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    result.add(name + "님이 나갔습니다.");
                    break;
            }
        }
        return result.toArray(new String[result.size()]);
    }
}