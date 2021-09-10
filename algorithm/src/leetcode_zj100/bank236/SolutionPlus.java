package leetcode_zj100.bank236;

import java.util.Stack;

/**
 * @author shengyi
 * @create 2021/8/27 - 5:21
 */
public class SolutionPlus {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //使用深度优先搜索，每一次搜索路径都用链表储存起来，从根节点找到p或q时，返回这个节点路径记录
        //得到两个几记录后，对记录进行顺序循环，最后一个相同的节点为所求
        Stack<TreeNode> sp = getX(root, p);
        Stack<TreeNode> sq = getX(root, q);
        TreeNode r = null;
        while (!sp.isEmpty() && !sq.isEmpty()) {
            TreeNode a = sp.pop();
            TreeNode b = sq.pop();

            if (a != b) {
                break;
            }
            r = a;
        }
        return r;
    }

    public Stack<TreeNode> getX(TreeNode root, TreeNode x) {
        if (root == null) {
            return null;
        }
        if (root == x) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            return stack;
        }
        Stack<TreeNode> left = getX(root.left, x);
        Stack<TreeNode> right = getX(root.right, x);
        if (left != null) {
            left.push(root);
            return left;
        }
        if (right != null) {
            right.push(root);
            return right;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Stack<>().empty());
    }
}
