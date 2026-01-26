import java.util.*;

class Solution {
        
    public class Node {
        int idx, x, y;
        Node left, right;
        
        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
                
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        // 정렬 - 1. y 기준 내림차순 -> 2. x 기준 오름차순
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        });
        
        Node root = nodes[0];
        
        // 트리 구성
        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;
            Node target = nodes[i];
            
            while (true) {
                if (parent.x > target.x) {
                    if (parent.left == null) {
                        parent.left = target;
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = target;
                        break;
                    } else { 
                        parent = parent.right;
                    }
                }
            }
        }
        
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        
        preOrder(root, preList);
        postOrder(root, postList);
        
        int[][] answer = new int[2][n];
        answer[0] = preList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    private void preOrder(Node cur, List<Integer> answer) {
        if (cur == null) return;
        answer.add(cur.idx);
        preOrder(cur.left, answer);
        preOrder(cur.right, answer);
    }
    
    private void postOrder(Node cur, List<Integer> answer) {
        if (cur == null) return;
        postOrder(cur.left, answer);
        postOrder(cur.right, answer);
        answer.add(cur.idx);
    }
}