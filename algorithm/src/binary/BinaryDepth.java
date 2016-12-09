package binary;


import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

/**
 * Created by yn on 2016/11/3.
 */
public class BinaryDepth {

    public static int maxDepth(TreeNode treeNode) {
        if (null == treeNode) return 0;
        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);
        return left>right?left+1:right+1;
    }

    /*
     *  Given a binary tree, find its minimum depth.
     *  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     *  1.入参为空 2.根节点的子节点只有一侧 (左侧或右侧) 3.根节点的两侧子节点均包含数据 4.根节点没有子节点
     */
    public static int minDepth(TreeNode treeNode) {
        if (null == treeNode) return 0;
        int left = minDepth(treeNode.right);
        int right = minDepth(treeNode.left);
        if (0 == left) return right+1;
        if (0 == right) return left+1;
        return Math.min(left, right)+1;
    }

    //别人的解法
    public static int minDepth_(TreeNode treeNode) {
        if (null == treeNode) return 0;
        if (null == treeNode.left) return minDepth_(treeNode.right)+1;
        if (null == treeNode.right) return minDepth_(treeNode.left)+1;
        return Math.min(minDepth_(treeNode.left), minDepth_(treeNode.right))+1;
    }

    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println("val is=="+node.val);
            if (null != node.left) queue.add(node.left);
            if (null != node.right) queue.add(node.right);
        }
    }

    //Binary Tree Level Order Traversal
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.val);
            if (null != current.left) queue.offer(current.left);
            if (null != current.right) queue.offer(current.right);
        }
        return list;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(5, new TreeNode(10), new TreeNode(11)))
//        , new TreeNode(3, new TreeNode(6, new TreeNode(12), new TreeNode(13)), new TreeNode(7, new TreeNode(14), new TreeNode(15))));
        TreeNode root = new TreeNode(1, new TreeNode(2));
        int minDepth = BinaryDepth.minDepth_(root);
        int maxDepth = BinaryDepth.maxDepth(root);
        System.out.println("minDepth is " + minDepth);
        System.out.println("maxDepth is " + maxDepth);

        TreeNode test = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List result = BinaryDepth.levelOrder(test);
        System.out.println(result);
    }

}

