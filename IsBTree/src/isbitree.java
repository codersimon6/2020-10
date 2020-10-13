import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        this.val = val;
    }
}

public class isbitree{

    public static boolean check(TreeNode root){
        if(root == null )return true;
        boolean tem = false;
        Queue<TreeNode> queuqe = new LinkedList<>();
        queuqe.offer(root);
        TreeNode cur = queuqe.poll();
        if(tem != true){
            if(cur.left != null && cur.right != null) {
                queuqe.offer(cur.left);
                queuqe.offer(cur.right);
            }else if(cur.left == null && cur.right != null){
                return false;
            }
            else if(cur.left != null && cur.right == null){
                tem = true;
            }else{ tem = true; }
        }
        else{
            if(cur.left != null || cur.right != null)return false;
        }
        return true;
    }
}
