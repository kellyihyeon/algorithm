package com.lab.studyplan.algorithm1.bfsdfs;


//Input: root = [1,0,1,0,1,0,1]
//Output: 22
//Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
public class SumOfRootToLeafBinaryNumbers1022 {

    int sum = 0;


    public int sumRootToLeaf(TreeNode root) {
        findNode(root, 0);
        return sum;
    }

    private void findNode(TreeNode root, int current) {
        if (root == null) {
            return;
        }

        current = 2 * current + root.val;
        if (root.left == null && root.right == null) {
            sum += current;
        }

        findNode(root.left, current);
        findNode(root.right, current);
    }
}
