package DoubleMyLinkedList;

class ListNode{
    public int val;
    public ListNode next;
    public ListNode prev;
    public ListNode() {  }
    public ListNode(int val){
        this.val = val;
    }
}
public class DoubleMyLinkedList {
    public ListNode head; //作用是，定位头节点的引用
    public ListNode last; //作用是，定位尾节点的引用

    public DoubleMyLinkedList () {
        head = new ListNode(-1);
    }

    public void addfirst(int data) {
        ListNode node = new ListNode(data);
        if (head.next == null) {
            head.next = node;
            node.prev = head;
            last = node;
            return;
        }
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public void addlast(int data) {
        ListNode node = new ListNode(data);
        if (head.next == null && last == null) {
            head.next = node;
            node.prev = head;
            last = node;
            return;
        }
        node.prev = last;
        last.next = node;
        last = node;
    }


    public boolean contains(int key) {
        if(head.next == null)return false;
        ListNode cur = head.next;
        while (cur != null){
            if(cur.val == key)return true;
            else cur = cur.next;
        }
        return false;
    }

    public int size(){
        if(head.next == null)return -1;
        ListNode cur = head.next;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void addindex(int index,int data){
        ListNode cur = head.next;
        if(index < 0 || index > size())return;
        if (index == 0)
        {
            addfirst(data);
            return;
        }
        if(index == size())
        {
            addlast(data);
            return;
        }
        while (index > 0){
            cur = cur.next;
            index --;
        }
        ListNode next = getPos(index);
        ListNode prev = next.prev;
        ListNode node = new ListNode(data);
        next.prev = node;
        node.prev = prev;
        prev.next = node;
        node.next = next;
    }

    //找到index下标对应的结点
    public ListNode getPos(int index) {
        ListNode cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    public void display(){
        ListNode cur = head.next;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode node = head.next;
        while(node != null) {
            if(node.val == key) {
                if(node == head.next) {
                    head.next = head.next.next;
                    head.next.prev = head;
                } else {
                    node.prev.next = node.next;
                    if (node.next != null) {
                        node.next.prev = node.prev;
                    } else {
                        last = node.prev;
                    }
                }
                return;
            } else {
                node = node.next;
            }
        }
    }

    public void removeall(int key){
        if(head == null)return;
        while (contains(key)){
            remove(key);
        }
    }
    public void clear(){
        head = null;
        last = null;
    }
}
