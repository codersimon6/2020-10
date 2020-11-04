package MyQueue;

class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}

class MyQueueByList {
    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public void offer(int data) {   //尾插
        Node node = new Node(data);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }
    public int poll() { //弹出队头元素
        check();
        //记录head节点
        Node prev = head;
        head = head.next;
        //只有一节点，需要把tail 也置为空
        if (head == null) {
            tail = null;
        }
        size--;
        return prev.val;
    }
    public void check(){
        if (size == 0) {
            throw new RuntimeException("队空");
        }
    }
    public int peek() {
        check();
        return head.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
