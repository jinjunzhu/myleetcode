package leetcode.tree;

/**
 * Created by jinjunzhu on 2019/3/27.
 * leetcode树相关的联系
 */
public class BinaryTreeTest {

    /**
     * 反转二叉树 时间复杂度 o(n)
     * https://leetcode.com/problems/invert-binary-tree/solution/
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 求二叉树最大深度 时间复杂度 o(n)
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /**
     * 验证二叉搜索树 时间复杂度 o(n)
     * https://leetcode.com/problems/validate-binary-search-tree/
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(null != root.left && root.left.val >= root.val){
            return false;
        }

        if (null != root.right && root.right.val <= root.val){
            return false;
        }
        return isValidBST(root.left) || isValidBST(root.right);
    }

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     * https://leetcode.com/problems/path-sum/
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null){
            return false;
        }
        //pathSum(0, root, sum);
        //return flag;

        if(root.left == null && root.right == null && sum - root.val == 0){
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

    //boolean flag = false;
    //private void pathSum(int currentSum, TreeNode treeNode, int sum){
    //    if (null != treeNode.left){
    //        pathSum(currentSum + treeNode.val, treeNode.left, sum);
    //    }
    //    if (null != treeNode.right){
    //        pathSum(currentSum + treeNode.val, treeNode.right, sum);
    //    }
//
    //    if (null == treeNode.left && null == treeNode.right){
    //        if (currentSum + treeNode.val == sum){
    //            flag = true;
    //            return;
    //        }
    //    }
    //}
}
