package MyLinkedList;

class Node {
    public int data;
    public Node next;//存储对象引用

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        //这里没有初始化next的引用是，不知道next当前指向那个
        //节点
    }
}

public class MySingleList {
    public Node head;//作用是，定位头节点的引用

    //头插法
    public void addFirst(int data) {
        Node cur = new Node(data);
        if (head != null) {
            cur.next = head;
        }
        head = cur;
    }

    //尾插法
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode ;
    }

    public Node searchprev(int index){
        int k = 0;
        Node cur = head;
        while (k < index){
            cur = cur.next;
            k++;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if(index < 0 || index > size())return;
        if(index == 0)addFirst(data);
        Node newNode = new Node(data);
        Node prev = searchprev(index);
        newNode.next = prev.next;
        prev.next = newNode;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (head == null) {
            return;
        }
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
//    public void removeAllKey(int key) {
//        if(head == null)return;
//        while (contains(key)){
//            remove(key);
//        }
//    }
    public void removeAllKey(int key){
        if(head == null)return;
        Node cur = head.next;
        Node prev = head;
        while (cur != null){
            if(cur.data == key){
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        if (head.data == key) {
            head = head.next;
            return;
        }

    }

    //得到单链表的长度
    public int size() {
        Node cur = head;
        int flag = 0;
        while (cur != null) {
            flag++;
            cur = cur.next;
        }
        return flag;
    }

    public void display() {
        if(head == null)return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }

    public void clear() {
        head = null;
    }

    public static void main(String[] args) {
        MySingleList list = new MySingleList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addLast(99);
        list.addFirst(3);
        list.addLast(3);
        list.addIndex(1,3);
        list.display();
        System.out.println();
//        System.out.println(list.searchprev(3).data);
        list.removeAllKey(3);
        list.display();
    }
}
