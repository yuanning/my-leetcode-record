/**
 * Created by yn on 2016/11/3.
 */
public class BinaryDepth {

    static int count = 1;

    //待修改
    public static int maxDepth(TreeNode treeNode) {
        if (null == treeNode)
            return 0;

        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;

        if (null!=left || null!=right)
            count++;

        maxDepth(left);
        maxDepth(right);
        return count;
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


        TreeNode a = new TreeNode(2, new TreeNode(4));
        TreeNode b = new TreeNode(3, new TreeNode(5));
        TreeNode c = new TreeNode(1, a, b);

        System.out.println(BinaryDepth.maxDepth(c));
    }


}

