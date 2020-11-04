package MyQueue.MyQueueByArray;

class MyCircularQueue {
    public int[] elem;
    public int size;
    public int front;
    public int rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.elem = new int[k];
        this.rear = 0;
        this.size = 0;
        this.rear = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elem[rear] = value;
        size ++;
        rear = rear == elem.length - 1 ? 0 : rear + 1;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = front == elem.length - 1 ? 0 : front + 1;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())return -1;
        return elem[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        //若尾为0，则最后元素为 elem[elem.length - 1]
        return rear == 0 ? elem[elem.length - 1] : elem[rear - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return rear == front;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear+1) % elem.length == front;
        // return size == elem.length;
    }
}

