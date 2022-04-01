package section07.section0709;

/**
 * 최단 거리 간선 구하기 - DFS (DFS 를 연습하기 위해 DFS 로 풀이)
 * DFS 를 풀 때 노드의 자식 노드는 left, right 2개 전부 있다고 가정.
 */
public class Main {

    private Node rootNode;

    private int DFS(int level, Node rootNode) { // 0, 1
        if (rootNode.getLeft() == null && rootNode.getRight() == null) {
            return level;
        } else {
            return Math.min(DFS(level + 1, rootNode.getLeft()), DFS(level + 1, rootNode.getRight()));
        }

    }

    public static void main(String[] args) {
        Main tree = new Main();

        tree.rootNode = new Node(1);
        tree.rootNode.setLeft(new Node(2));
        tree.rootNode.setRight(new Node(3));

        tree.rootNode.getLeft().setLeft(new Node(4));
        tree.rootNode.getLeft().setRight(new Node(5));

        System.out.println(tree.DFS(0, tree.rootNode));
    }
}
