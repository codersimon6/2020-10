import java.util.Arrays;

public class heap {

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

    //向上调整,基本思路相同，不写注释
    public  static void shiftfup(int []array,int index){
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

    public static void creat(int array[],int size){
        //若基于向下调整建堆，则需要从后往前遍历。否则会出错
        for(int i = (size-1-1)/2;i >= 0;i--){
            // size-1是找到最后的叶子节点，而再-1并且除2，是找到父节点
            shiftdown( array,size ,i);
        }
    }


    public static void main(String[] args) {
        int []array = {9,5,2,7,3,6,8};
        creat(array,array.length);
        System.out.println(Arrays.toString(array));
    }

}
