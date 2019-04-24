package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
 * Created by jinjunzhu on 2019/4/11.
 */
public class ZigZagBinaryTree {

    /**
     * 模拟2个栈  左边的栈先放right后放left  右边的栈先放left后放right
     * @param root
     * @return
     */
    public List<List<Integer>> Solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();

        list1.add(root);
        while (true){
            if (list1 .size() == 0){
                break;
            }
            list2.clear();
            List<Integer> temp = new ArrayList<>();
            for (int i = list1.size() - 1; i >= 0; i--){
                TreeNode node = list1.get(i);
                temp.add(node.val);
                if (node.left != null){
                    list2.add(node.left);
                }
                if (node.right != null){
                    list2.add(node.right);
                }
            }
            result.add(temp);
            if (list2 .size() == 0){
                break;
            }
            list1.clear();
            List<Integer> temp1 = new ArrayList<>();
            for (int i = list2.size() - 1; i >= 0; i--){
                TreeNode node = list2.get(i);
                temp1.add(node.val);
                if (node.right != null){
                    list1.add(node.right);
                }
                if (node.left != null){
                    list1.add(node.left);
                }
            }
            result.add(temp1);
        }
        return result;
    }
}
