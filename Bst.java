package com.hr.hackerrankproblems.leetCode;

class TreeNode {
    int val;
    TreeNode left,right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Bst {
    public TreeNode sortedToBst(int[] nums){
        return helper(nums, 0 , nums.length -1);
    }
    
    private TreeNode helper(int []nums,int left,int right){
        if(left > right) return null;
        int mid = left + (right -left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid -1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
    
    static void printTree(TreeNode root){
        if(root == null) return;
//        printTree(root.left);
        System.out.println(root.val + "\n");
//        printTree(root.right);
    }
    
    public static void main(String[] args) {
        Bst b = new Bst();
        TreeNode root = b.sortedToBst(new int[] {-5,-4,0,1,2,3,4});
        printTree(root);
    }
    
}
