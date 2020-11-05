package MyQueue;

/**
 * 循环双端队列
 */
class MyCircularDeque {
    public int[] elem;
    public int size;
    public int front;
    public int rear;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.elem = new int[k ];
        this.rear = 0;
        this.size = 0;
        this.rear = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == elem.length) {
            return false;
        }
        if (front == 0) {
            elem[elem.length - 1] = value;
            front = elem.length - 1;
        } else {
            elem[--front] = value;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == elem.length) {
            return false;
        }
        elem[rear] = value;
        size++;
        rear = rear == elem.length - 1 ? 0 : rear + 1;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        front = front == elem.length - 1 ? 0 : front + 1;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (rear == 0) {
            rear = elem.length - 1;
        } else {
            rear--;
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return elem[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return rear == 0 ? elem[elem.length - 1] : elem[rear - 1];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == elem.length;
    }
}
