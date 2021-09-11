package leetcode_zj100.bank236;

/**
 * @author shengyi
 * @create 2021/8/27 - 4:14
 * medium
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getParent(root, p, q);
    }

    public TreeNode getParent(TreeNode treeNode, TreeNode p, TreeNode q) {
        //根节点就是p或q时
        if (treeNode == p || treeNode == q) {
            return treeNode;
        }
        //p 或 q 分别在根节点左右两边时
        if ((getX(treeNode.left, p.val) == p || getX(treeNode.left, q.val) == q) && (getX(treeNode.right, p.val) == p || getX(treeNode.right, q.val) == q)) {
            return treeNode;
        }
        //
        if (getX(treeNode.left, p.val) == p || getX(treeNode.left, p.val) == p) {
            return getParent(treeNode.left, p, q);
        } else {
            return getParent(treeNode.right, p, q);
        }
    }

    public TreeNode getX(TreeNode treeNode, int x) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.val == x) {
            return treeNode;
        }
        TreeNode left = getX(treeNode.left, x);
        TreeNode right = getX(treeNode.right, x);
        if (left != null) {
            return left;
        } else return right;
    }
}
