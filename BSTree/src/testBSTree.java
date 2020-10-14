
/**
 * 二叉搜索树又称二叉排序树，它或者是一棵空树或者是具有以下性质的二叉树:
 * 若它的左子树不为空，则左子树上所有节点的值都小于根节点的值
 * 若它的右子树不为空，则右子树上所有节点的值都大于根节点的值
 * 它的左右子树也都为二叉搜索树
 */
public class testBSTree {
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    //根节点，root == null为空树
    private Node root = null;

    public Node find(int key) {
        Node cur = root;
        while (cur != null) {
            //如果要找的数大于当前节点值，就去右子树找
            if (cur.key < key) cur = cur.right;
                //如果要找的数小于当前节点值，就去左子树找
            else if (cur.key > key) cur = cur.left;
                //如果要找的数大于当前节点值，就去右子树找
            else return cur;
        }
        return null;
    }

    public boolean insert(int key) {
        Node p = new Node(key);
        if (root == null) {
            root = p;
            return true;
        }
        //二叉搜索树插入元素都是插入到叶子节点
        //和查找类似，需要先找到合适的位置。再去插入元素。
        Node cur = root;
        //parent始终指向cur的父节点。和链表插入类似，也需要记录指定位置的前一个节点。
        Node parent = null;
        while (cur != null) {
            //如果要找的数大于当前节点值，就去右子树找
            if (cur.key < key) {
                parent = cur;
                cur = cur.right;
            }
            //如果要找的数小于当前节点值，就去左子树找
            else if (cur.key > key) {
                parent = cur;
                cur = cur.left;
            } else
                //当前元素与插入元素相等，插入失败
                return false;
        }
        //查找结束，cur = null;比较parent.key和key大小，决定左插还是右插
        if (key > parent.key) parent.right = p;
        else
            parent.left = p;
        return true;
    }

    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            ////如果要找的数大于当前节点值，就去右子树找
            if (cur.key < key) {
                parent = cur;
                cur = cur.right;
            }
            //如果要找的数小于当前节点值，就去左子树找
            else if (cur.key > key) {
                parent = cur;
                cur = cur.left;
            } else {
                //找到要删除的节点，删除成功，返回true
                removehelp(parent, cur);
                return true;
            }
        }
        return false;
    }

    public boolean removehelp(Node parent, Node cur) {
        // 此时cur就是要删除的结点,parent为其父结点
        // 要删除结点为叶子结点
        if (cur.left == null && cur.right == null) {
            if (cur == root) root = null; // 整棵树清空
            if (parent.left == cur) {
                //要删除节点为父节点的左子树，则左子树设为null。
                parent.left = null;
            }
            if (parent.right == cur) {
                //要删除节点为父节点的右子树，则右子树设为null。
                parent.right = null;
            }
        }
        // 要删除结点有左子树
        if (cur.left != null) {
            //如果要删除的节点为根节点。则新的根节点为其左子树
            if (cur == root) root = root.left;
            //如果要删除的节点为父节点的左子树
            if (parent.left == cur) parent.left = cur.left;
            //如果要删除的节点为父节点的右子树
            if (parent.right == cur) parent.right = cur.left;
        }
        // 要删除结点有右子树
        if (cur.right != null) {
            //如果要删除的节点为根节点。则新的根节点为其右子树
            if (cur == root) root = root.left;
            //如果要删除的节点为父节点的左子树
            if (parent.left == cur) parent.left = cur.right;
            //如果要删除的节点为父节点的右子树
            if (parent.right == cur) parent.right = cur.right;
        }
        //要删除的节点有左右子树
        if (cur.left != null && cur.right != null) {
            //用右子树中的最小节点(或者左子树最大节点)，把要删除的节点替换掉，
            // 然后删掉刚才找到的最小(或者最大)节点
            int min = findmin(cur.right);
            cur.key = min;
        }
        return true;
    }

    // 返回和删除一颗树中最小的节点
    public int findmin(Node node)
    {
        Node parent = null;
        Node cur = node;
        //最小节点一定没有左子树，按删除代码删除即可
        while(cur.left != null)
        {
            parent = cur;
            cur = cur.left;
        }
        int min = cur.key;
        removehelp(parent,cur);
        return min;
    }

    //递归先序遍历
    public void PreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
    //递归中序遍历
    public void MidOrder(Node root) {
        if (root == null) {
            return;
        }
        MidOrder(root.left);
        System.out.print(root.key + " ");
        MidOrder(root.right);
    }
    //递归后序遍历
    public void LastOrder(Node root) {
        if (root == null) {
            return;
        }
        LastOrder(root.left);
        LastOrder(root.right);
        System.out.print(root.key + " ");
    }
    public static void main(String[] args) {
        testBSTree bst = new testBSTree();
        bst.insert(9);
        bst.insert(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);
        bst.MidOrder(bst.root);
        System.out.println();
        System.out.println(bst.find(7));
        bst.remove(6);
        bst.MidOrder(bst.root);
    }
}

