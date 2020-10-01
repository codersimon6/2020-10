import java.util.LinkedList;

class Node{
     String val;
     Node left;
     Node right;
     public Node(String val){
         this.val = val;
    }
}

public class Mytree {
    public static Node Tree(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;
        return a;
    }

    public static void PreOrder(Node root){
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public static void MidOrder(Node root){
        if (root == null) {
            return;
        }
        MidOrder(root.left);
        System.out.print(root.val+" ");
        MidOrder(root.right);
    }

    public static void LastOrder(Node root){
        if (root == null) {
            return;
        }
        LastOrder(root.left);
        LastOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static void LevalOrder(Node root){
        LinkedList<Node> list = new LinkedList<>();
        if(root == null)return;
        list.add(root);
        while (list.isEmpty() == false ) {
            Node tem = list.poll();
            System.out.print(tem.val+" ");
            if(tem.left != null){
                list.add(tem.left);
            }
            if(tem.right != null){
                list.add(tem.right);
            }
        }
    }

    public static int Size(Node root){
        if(root == null)return 0;
        int tem = 0;
        tem = 1+Size(root.left)+Size(root.right);
        return tem;
    }

    public static int LeafNode(Node root){
        if(root == null)return 0;
        if(root.left == null && root.right == null)return 1;
        return LeafNode(root.left)+ LeafNode(root.right);
    }

    public static int LvelSize(Node root,int k){
        if(k < 1 || root == null)return 0;
        if(k == 1)return 1;
        return LvelSize(root.left,k-1)+LvelSize(root.right,k-1);
    }

    public static Node Find(Node root,String a){
        if(root == null)return null;
        if(root.val.equals(a))return root;
        Node result = Find(root.left,a);
        if(result != null) return result;
        else return Find(root.right,a);
    }


    public static void main(String[] args) {
        Node root = Tree();
        System.out.print("先序遍历：");PreOrder(root);
        System.out.println("");
        System.out.print("中序遍历：");MidOrder(root);
        System.out.println("");
        System.out.print("后序遍历：");LastOrder(root);
        System.out.println("");
        System.out.print("层序遍历：");LevalOrder(root);
        System.out.println("");
        System.out.println(Size(root));
        System.out.println(LeafNode(root));
        System.out.println(LvelSize(root,3));
        System.out.println(Find(root,"F"));
    }
}
