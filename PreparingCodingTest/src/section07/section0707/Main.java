package section07.section0707;


import java.util.LinkedList;
import java.util.Queue;

class Node {
    
    private int root;
    private Node left;
    private Node right;

    public Node(int root) {
        this.root = root;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "root=" + root +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
/**
 * 이진트리 순회 (넓이 우선 탐색: 레벨 탐색)
 * 레벨 탐색 순회 출력: 1 2 3 4 5 6 7
 */
public class Main {
    
    private Node root;

    //      1
    //  2       3
    //4   5   6   7
    private void BFS(Node node) {
        Queue<Node> queue = new LinkedList<>(); // [4 5 6 7
        queue.offer(node);
        int level = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();
            System.out.print(level + " : ");

            for (int i = 0; i < length; i++) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.getRoot() + " ");
                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight());
                }
            }
            level++;
            System.out.println();
        }

    }


    public static void main(String[] args) {
        Main M = new Main();

        M.root = new Node(1);
        M.root.setLeft(new Node(2));
        M.root.setRight(new Node(3));

        M.root.getLeft().setLeft(new Node(4));
        M.root.getLeft().setRight(new Node(5));

        M.root.getRight().setLeft(new Node(6));
        M.root.getRight().setRight(new Node(7));

        M.BFS(M.root);
        System.out.println("M.root = " + M.root);
    }
}
