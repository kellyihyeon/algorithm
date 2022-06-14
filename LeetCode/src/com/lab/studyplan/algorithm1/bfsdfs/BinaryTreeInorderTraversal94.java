package com.lab.studyplan.algorithm1.bfsdfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {

    //Input: root = [1,null,2,3]
    //Output: [1,3,2]
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
