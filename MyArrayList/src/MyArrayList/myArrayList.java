package MyArrayList;


import java.util.Currency;

public class myArrayList {
    public int size;
    public int[] Array;

    public myArrayList(){
        this.size = 0;
        this.Array = new int[10];
    }
    public myArrayList(int capcity){
        this.size = 0;
        this.Array = new int[capcity];
    }

    // 打印顺序表
    public void display() {
        for(int i = 0 ;i < size;i++){
            System.out.print(Array[i]+" ");
        }
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(pos < 0 || pos > size)return;
        for(int i = size - 1;i >= pos;i--){
            Array[i + 1] = Array[i];
        }
        Array[pos] = data;
        size++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if (size == 0) return false;
        for (int i = 0; i < size; i++) {
            if (Array[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(size == -1)return -1;
        for (int i = 0;i < size;i++){
            if(Array[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos < 0 || pos >= size)return -1;
        return Array[pos];
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos >= size)return;
        Array[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(!contains(toRemove)){
            return;
        } else{
            for(int i = search(toRemove);i < size - 1;i++) {
                Array[i] = Array[i + 1];
            }
        }
        size--;
    }
    // 获取顺序表长度
    public int size() {
        return size;
    }

    // 清空顺序表
    public void clear() {
        size = 0;
    }
    public void delete(int toRemove) {
        if(!contains(toRemove)){
            return;
        }
        while (contains(toRemove)){
            remove(toRemove);
        }
    }


    public static void main(String[] args) {
        myArrayList Array = new myArrayList();
        Array.add(0,1);
        Array.add(0,1);
        Array.add(0,1);
        Array.add(0,1);
        Array.add(0,5);
        Array.add(0,6);
        Array.add(0,1);
        Array.add(0,1);
        Array.display();
        System.out.println();
        Array.delete(1);
        Array.display();
    }
}
