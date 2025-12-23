import java.util.*;

class Solution {
    
    private static class Node {
        int x, y, num;
        Node left, right;
        
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    // 이진 트리 생성
    private static Node makeBT(int[][] nodeinfo) {
    
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        // 정렬 (y 기준 내림차순, y가 같다면 x 기준 오름차순)
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        });
        
        Node root = nodes[0];
        
        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;
            
            while (true) {
                // 부모 노드의 x좌표가 더 크면 왼쪽으로
                if (parent.x > nodes[i].x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                }
                // 부모 노드의 x좌표가 더 작거나 같으면 오른쪽으로
                else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        
        return nodes[0];
    }
    
    // 전위 순회
    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) return;
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }
    
    // 후위 순회
    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) return;
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        
        Node root = makeBT(nodeinfo);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);
    
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}