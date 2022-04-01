package section07.section0709;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree 말단 노드까지 가장 짧은 경로 구하기 - BFS
 *        1
 *   2        3
 * 4  5
 */
public class Main2 {

    public static void main(String[] args) {
        // 제시된 그림처럼 노드 그래프를 만든다.
        // BFS 로 푼다면?
        Node rootNode = new Node(1);
        rootNode.setLeft(new Node(2));
        rootNode.setRight(new Node(3));

        rootNode.getLeft().setLeft(new Node(4));
        rootNode.getLeft().setRight(new Node(5));

        Main2 M = new Main2();
        System.out.println(M.BFS(rootNode));

    }

    // 노드가 left, right 자식 노드를 가지고 있다면 queue 에 담는다. 1 2 3[ 4 5
    // 노드를 꺼내서 left, right 자식 노드를 확인하고 queue 에 담는다. 꺼낸 노드에 자식 노드가 없다면 간선의 갯수를 리턴한다.
    private int BFS(Node rootNode) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(rootNode);  // 1번 넣고
        int line = 0;

        while (!queue.isEmpty()) {
            // *** 배운점: 레벨별로 묶는 방법을 모르겠다. -> queue 의 사이즈를 이용해서 for 문으로 노드를 레벨별로 묶을 수 있다 !
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node currentNode = queue.poll();
                if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                    return line;
                }

                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight());
                }
            }
            // 간선의 갯수는 체크를 할 필요가 있다. 노드를 꺼내고 자식 노드를 큐에 담고 나서 간선 갯수를 +1 해준다.
            // 같은 레벨 노드를 다 훑고 나서 라인을 ++ 해줘야 한다.
            line++;

        }

        return answer;
    }
}
