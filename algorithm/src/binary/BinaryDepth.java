package binary;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     *   3
        / \
       9  20
         /  \
       15   7
     return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7]
     ]
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (null == root) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i=0; i<levelNum; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            result.add(subList);
        }
        return result;
    }

    public static List<List<Integer>> levelOrderByDfs(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelOrder(result, root, 0);
        return result;
    }

    public static void levelOrder(List<List<Integer>> list, TreeNode root, int level) {
        if (null==root) return;
        if (list.size()<=level) {
            list.add(new LinkedList<Integer>());
        }
        list.get(level).add(root.val);
        levelOrder(list, root.left, level+1);
        levelOrder(list, root.right, level+1);
    }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(5, new TreeNode(10), new TreeNode(11)))
//        , new TreeNode(3, new TreeNode(6, new TreeNode(12), new TreeNode(13)), new TreeNode(7, new TreeNode(14), new TreeNode(15))));
        //TreeNode root = new TreeNode(1, new TreeNode(2));
        //int minDepth = BinaryDepth.minDepth_(root);
        //int maxDepth = BinaryDepth.maxDepth(root);
        //System.out.println("minDepth is " + minDepth);
        //System.out.println("maxDepth is " + maxDepth);

        TreeNode test = new TreeNode(3, new TreeNode(9, new TreeNode(6), new TreeNode(5)), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List result = BinaryDepth.levelOrderByDfs(test);
        System.out.println(result);
    }

}

