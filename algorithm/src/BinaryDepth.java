import java.util.Queue;
import java.util.Stack;

/**
 * Created by yn on 2016/11/3.
 */
public class BinaryDepth {

    public static int maxDepth(TreeNode treeNode) {
         if (null == treeNode)
            return 0;

        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);

        System.out.println(treeNode.hashCode());

        return left>right?left+1:right+1;
    }

    public static void main(String[] args) {

        TreeNode a = new TreeNode(2, new TreeNode(4));
        TreeNode b = new TreeNode(3, new TreeNode(5, new TreeNode(6)));
        TreeNode c = new TreeNode(1, a, b);

        System.out.println(BinaryDepth.maxDepth(c));
    }

}

