package MyLinkedList;

class ListNode{
    public int val ;
    public ListNode next;
    public ListNode(int val)
    {
        this.val = val;
    }
}


public class MyList {
    private ListNode head = null;
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).val);
        }
        System.out.println("***************");
        System.out.println(list.get(2).val);
        System.out.println("***************");
        System.out.println(list.delete(2));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).val);
        }
        System.out.println(list.find(2));
        System.out.println("***************");
    }

    public ListNode get(int x) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        for (int i = 1; i <= x; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean add(int a) {
        ListNode newNode = new ListNode(a);
        if (head == null) {
            head = newNode;
            return true;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode ;
        return true;
    }

    public int find(int a) {
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            if (cur.val == a) {
                return index;
            }
            index++;
            cur = cur.next;
        }
        return -1;
    }

    public boolean delete(int a) {
        if (head == null) {
            return false;
        }
        if (head.val == a) {
            head = head.next;
            return true;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == a) {
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

//    public boolean delete(int a){
//        if(head == null){
//            return false;
//        }
//        if(head.val == a){
//            head = head.next;
//            return true;
//        }
//        MyLinkedList.ListNode prev = head;
//        MyLinkedList.ListNode cur = prev.next;
//        while(cur != null){
//            if(cur.val == a){
//                prev.next = cur.next;
//                return true;
//            }
//            prev = prev.next;
//            cur = cur.next;
//        }
//        return false;
//    }

    public int size() {
        ListNode cur = head;
        int flag = 0;
        while (cur != null) {
            flag++;
            cur = cur.next;
        }
        return flag;
    }

    public ListNode addfirst(int a) {
        ListNode cur = new ListNode(a);
        if (head == null) {
            head = cur;
        } else {
            cur.next = head;
        }
        return head;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tem = cur.next;//
            cur.next = pre;//
            pre = cur;//
            cur = tem;
        }
        return pre;
    }

}
