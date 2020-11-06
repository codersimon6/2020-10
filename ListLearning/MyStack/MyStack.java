package MyStack;
import java.util.Arrays;

class myStack {
    public int[] elem;
    public int size;
    public myStack() {
        this.elem = new int[5];
        size = 0;
    }
    public void push(int data){
        if (isFull()){
            int[] tem = Arrays.copyOf(elem,elem.length*2);
            elem = tem;
        }
        elem[size++] = data;
    }
    public void display(){
        for (int t = 0; t < size;t++) {
            System.out.print(elem[t]);
        }
    }
    public int pop() {
        int tem = peek();
        size--;
        return tem;
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("NULL");
        }
        return elem[size -1];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == elem.length;
    }
}

public class MyStack {
    public static void main(String[] args) {
        myStack stack = new myStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.display();
    }
}
