package binary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yn on 2016/9/18.
 */
public class BinaryTree {
    public TreeNode invert(TreeNode treeNode) {
        if (null != treeNode) {
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            TreeNode temp = null;

            //exchange
            temp = left;
            left = right;
            right = temp;

            treeNode.left = left;
            treeNode.right = right;

            invert(left);
            invert(right);
        }
        return treeNode;
    }

    /**
     *      4
     *    /  \
     *   2    7
     *  / \  / \
     * 1   3 6  9
     *
     * to
     *
     *      4
     *    /  \
     *   7    2
     *  / \  / \
     * 9   6 3  1
     **/

    //modified
    public TreeNode invertModified(TreeNode treeNode) {
        if (null!=treeNode) {
            System.out.println(treeNode.val);
            TreeNode left = invertModified(treeNode.left);
            TreeNode right = invertModified(treeNode.right);
            treeNode.left = right;
            treeNode.right = left;
        }
        return treeNode;
    }

    //Standard Answer
    public TreeNode invert_(TreeNode treeNode) {
        if (null!=treeNode) {
            TreeNode left = invert_(treeNode.left);
            TreeNode right = invert_(treeNode.right);

            //exchange
            treeNode.left = right;
            treeNode.right = left;
        }
        return treeNode;
    }

    public static void main(String[] args) {
        /**
         * initialize data
         */
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(3);
//        TreeNode c = new TreeNode(2, a, b);
//        TreeNode d = new TreeNode(6);
//        TreeNode e = new TreeNode(9);
//        TreeNode f = new TreeNode(7, d, e);
//        TreeNode g = new TreeNode(4, c, f);
//
        BinaryTree binaryTree = new BinaryTree();
//        TreeNode result = binaryTree.invertModified(g);
//        System.out.println(result);
        //binaryTree.foreach(g);

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(5)), new TreeNode(3));
        binaryTree.binaryTreePaths(root);
    }

    //foreach binary tree
    public void foreach(TreeNode treeNode) {
        if (null!=treeNode) {
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            if (null != left && null != right) {
                System.out.println(left.val);
                System.out.println(right.val);
                System.out.println("\n");
            }
            foreach(left);
            foreach(right);
        }
    }

    //binary tree paths  output example:["1->2->5", "1->3"]
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        recordPath(result, root, "");
        return result;
    }

    public void recordPath(List<String> result, TreeNode node, String path) {
        if (null == node) return;
        if (null == node.left && null == node.right) result.add(path + node.val);
        if (null != node.left) recordPath(result, node.left, path + node.val + "->");
        if (null != node.right) recordPath(result, node.right, path + node.val + "->");
    }

}


