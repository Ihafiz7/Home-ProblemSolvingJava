package com.hr.hackerrankproblems.leetCode;

//class TreeNode {
//    int val;
//    TreeNode left, right;
//    TreeNode(int val) { 
//        this.val = val;
//    }
//}

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }

    void inorderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -2, 0, 1,2,7, 4, 9};
        SortedArrayToBST solution = new SortedArrayToBST();
        TreeNode root = solution.sortedArrayToBST(nums);

        solution.inorderPrint(root);
        System.out.println();

    }

}
