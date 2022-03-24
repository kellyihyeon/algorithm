package section07.section0705;

/**
 * 이진트리 순회 (깊이 우선 탐색)
 * 연습: 출력하기
 * 전위 순회   1 2 4 5 3 6 7
 * 중위 순회   4 2 5 1 6 3 7
 * 후위 순회   4 5 2 6 7 3 1 -> 병합 정렬
 * -> 부모 노드를 기준으로 부모 노드를 언제 방문하느냐에 따라 전위/중위/후위로 나뉜다.
 */

class Node {

    private final int data;
    private Node lt;
    private Node rt;

    public Node(int val) {
        this.data = val;
    }

    public void setLt(Node lt) {
        this.lt = lt;
    }

    public void setRt(Node rt) {
        this.rt = rt;
    }

    public int getData() {
        return data;
    }

    public Node getLt() {
        return lt;
    }

    public Node getRt() {
        return rt;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", lt=" + lt +
                ", rt=" + rt +
                '}';
    }
}


public class Main {
    
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    //      1
    //  2       3
    //4   5   6   7
    private void preOrderDFS(Node root) {
        // 전위 순회   1 2 4 5 3 6 7
        if (root == null) {
            return;
        } else {
            System.out.print(root.getData() + " ");
            preOrderDFS(root.getLt());
            preOrderDFS(root.getRt());
        }
    }


    private void inOrderDFS(Node root) {  // d(1)
        // 중위 순회   4 2 5 1 6 3 7 -> 왼쪽 ->루트->오른쪽
        if (root == null) {
            return;
        } else {
            inOrderDFS(root.getLt());
            System.out.print(root.getData() + " "); // 4 2 5 1 6 3 7
            inOrderDFS(root.getRt());
        }
    }

    private void postOrderDFS(Node root) {
        // 후위 순회   4 5 2 6 7 3 1
        if (root == null) {
            return;
        } else {
            postOrderDFS(root.getLt());
            postOrderDFS(root.getRt());
            System.out.print(root.getData() + " ");  // 4 5 2 6 7 3 1
        }
    }



    public static void main(String[] args) {
        Main tree = new Main();

        tree.setRoot(new Node(1));
        Node root = tree.getRoot();

        root.setLt(new Node(2));
        root.setRt(new Node(3));

        root.getLt().setLt(new Node(4));
        root.getLt().setRt(new Node(5));

        root.getRt().setLt(new Node(6));
        root.getRt().setRt(new Node(7));

        tree.preOrderDFS(root);   // 전위 순회
        System.out.println();
        tree.inOrderDFS(root);    // 중위 순회
        System.out.println();
        tree.postOrderDFS(root);  // 후위 순회
        System.out.println();

        System.out.println("root = " + root);

    }

}
