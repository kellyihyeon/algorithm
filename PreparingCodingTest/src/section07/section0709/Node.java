package section07.section0709;

public class Node {
    private final int nodeNumber;
    private Node left;
    private Node right;


    public Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
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
                "nodeNumber=" + nodeNumber +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
