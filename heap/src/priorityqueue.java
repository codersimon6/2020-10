import java.util.Arrays;

public class priorityqueue {
    private int []array= new int[100];
    private int size = 0;

    //入队列
    public void offer(int x){
        array[size] = x;
        size ++;
        //新插入元素可能破坏原先的优先队列，对其进行向上调整
        shiftup(array,size-1);
    }

    //出队列，即将下标为0的元素删除并返回。
    //具体思路:用最后一个元素替换第一个元素，同时size—，删掉最后一个元素。
    //对第一个元素出发，进行向下调整即可
    public int poll(){
        int pollnum = array[0];
        array[0] = array[size-1];
        size --;
        shiftdown(array,size,0);
        return pollnum;
    }

    public int peek(){
        return array[0];
    }

    //向下调整，按大堆实现(父节点值大于子节点）
    public static void shiftdown(int []array,int size,int index){
        //array表示要处理的数组。size表示处理的数据大小，index表示从什么位置开始处理。

        int parent = index;
        int child = parent*2 +1;
        //已知双亲(parent)的下标，则：左孩子(left)下标 = 2 * parent + 1; 右孩子(right)下标 = 2 * parent + 2;
        //已知孩子（不区分左右）(child)下标，则： 双亲(parent)下标 = (child - 1) / 2;

        while (child < size){ //child > size说明parent无子节点
            if(child + 1 < size && array[child] < array[child+1]){
                //找到子节点中较大的下标
                child = child + 1;
            }
            if(array[child] > array[parent]){
                // 若子节点值大于父节点值，交换。
                int tem = array[child];
                array[child] = array[parent];
                array[parent] = tem;
            }else{   //否则，说明符合要求，停止当前循环
                break;
            }
            parent = child;  //当前的子节点重新当作父节点，继续循环
            child = 2 * parent + 1;
        }
    }

    public  static void shiftup(int []array,int index){
        int child = index;
        int parent = (child -1) /2;
        while (child > 0){
            if(array[child] > array[parent]){
                int tem = array[child];
                array[child] = array[parent];
                array[parent] = tem;
            }else {break;}
            child = parent;
            parent = (child -1) /2;
        }
    }

    public boolean isempy(){
        return size==0;
    }

    public static void main(String[] args) {
        priorityqueue queue = new priorityqueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.isempy()){
            System.out.println(queue.poll());
        }
    }
}
