package com.lab.studyplan.algorithm1.bfsdfs;

public class InvertBinaryTree226 {

    //Input: root = [4,2,7,1,3,6,9]
    //Output: [4,7,2,9,6,3,1]
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }
}
