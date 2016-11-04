/**
 * Created by yn on 2016/9/18.
 */
public class BinaryTree {

    //my initial solution
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
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(2, a, b);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(9);
        TreeNode f = new TreeNode(7, d, e);
        TreeNode g = new TreeNode(4, c, f);

        BinaryTree binaryTree = new BinaryTree();
        TreeNode result = binaryTree.invertModified(g);
        System.out.println(result);
        //binaryTree.foreach(g);
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

}


//invert binary tree
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }


    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode child) {
        this(val, child, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}