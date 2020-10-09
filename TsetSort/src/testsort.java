import java.util.Arrays;
import java.util.Stack;

public class testsort {

    public static void InsertSort(int []array){
        //[0,bound)为已排序区间，[index，size]为待排区间
        //取array[index]与前bound个已排序的数分别进行比较，如果大于则不变，小于则交换二者位置，
        // 直到找到合适位置插入。然后bound++，index++
        for (int bound = 1;bound < array.length;bound++){
            int index = bound;
            while (index > 0){
                if(array[index] > array[index-1])break;
                else {
                    int tem = array[index];
                    array[index] = array[index-1];
                    array[index - 1] = tem;
                    index--;
                }
            }
        }
    }
    public static void ShellSort(int []array){
        int gap = array.length;
        while (gap > 1){
            gap = gap/2;
            for (int i = gap;i<array.length;i++) {
                while (i > gap ) {
                    if (array[i] > array[i - gap])break;
                    int tem = array[i];
                    array[i] = array[i - gap];
                    array[i - gap] = tem;
                    i = i - gap;
                }
            }
        }
    }
    public static void SelectSort(int []array){
        // 以bound位置元素为擂主，循环从待排序列表取元素进行对比。
        // 如满足题意，则交换位置，并且bound后移继续比较，到结束为止。
        for(int bound = 0;bound < array.length;bound++){
            for (int index = bound +1;index < array.length;index++){
                if(array[bound]>array[index]){
                    int tem = array[index];
                    array[index] = array[bound];
                    array[bound] = tem;
                }
            }
        }
    }

    public static void HeapSort(int []array){
        Creadheap(array);
        //将第一个元素，即最大数,和最后一个数交换.然后将最后一个数划分到已排区间。
        //对第一个元素进行向下调整，重新化为大堆。重复操作即可。
        for(int i = 0;i<array.length-1;i++){
            //[0,array.length-1)为初始待排区间，[array.length-1,array.length)为已排区间。
            //每删除一个最后节点，待排区间-1，已排区间+1。即
            //[0,array.length-1-i)待排区间，[array.length-1-i,array.length)为已排区间
            swap(array,0,array.length-1-i);
            Shiftdown(array,array.length-i-1,0);
        }
    }
    public static void swap(int []array,int a,int b){
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }
    public static void Creadheap(int []array){
        for(int i = (array.length - 1 - 1)/2;i >= 0;i--){
            Shiftdown(array,array.length,i);
        }
    }
    public static void Shiftdown(int []array,int heaplength,int index){
        //从最后一个非叶子节点出发，向下调整。建成大堆。
        int parent = index;
        int child = 2*parent +1;
        while (child < heaplength){
            if(child+1 < heaplength && array[child] < array[child+1]) child = child+1;
            if(array[child] > array[parent])swap(array,parent,child);
            else break;
            parent = child;
            child = 2*parent +1;
        }
    }

    public static void BubbleSort(int []array){
        //如果找最小，则从后往前遍历交换。如果找最大，则从前往后遍历
        //此处找最大。[0,bound)为待排序区间。[bound,size)为已排序区间
        //最后一个数不用排，因为他没有后一位，而且倒数第二位已经和他比较过
        //每排一次，待排区间也就是内层for - 1.
        for(int bound = 0;bound < array.length - 1;bound++){
            for(int tem = 0 ;tem < array.length - 1 - bound; tem ++){
                if(array[tem] > array[tem +1])swap(array,tem,tem+1);
            }
        }
    }

    //快速排序递归实现
    public static void QuickSort(int []array,int left,int right){
        if(left > right)return;
        int index = getindex(array,left,right);
        //根据基准值把数组分为左右两个区间。
        // 其中左区间全部小于基准值，右区间全部大于基准值
        // 递归处理左右区间
        QuickSort(array, left, index - 1);
        QuickSort(array, index + 1, right);
    }
    public static int getindex(int []array,int left,int right){
        int begin = left;
        int end = right;
        int index = array[right]; //首先取基准值为最右侧。
        while (begin < end){
            // 然后从左开始找，找到一个数大于基准值停止。
            while (begin < end && array[begin] <= index){
                begin++;
            }
            //然后从右继续，找到小于基准值停止，交换他们位置。
            // 如果左右指针不重合，也就是begin<end，继续循环。
            while (begin < end && array[end] >= index){
                end--;
            }
            //如果循环结束，也就是左右指针重合，此时重合位置一定大于基准值。
            //证明:1.如果因为begin++导致和end重合。因为重合之前begin最后一次循环是找到了一个大于基准值的数，交换给了end
            // array[end]一定大于基准值，而begin和其重合。则说明重合位置在end处，也是大于基准值的
            //2.如果end—-导致和begin重合。由于能运行到end—-，说明上边begin++循环停止。
            // 也就是begin找到了一个比基准值大的数，停止了循环。此时end和begin重合，说明该位置为array[begin]一定比基准值大
            swap(array,begin,end);
        }
        // 将重合的位置元素和基准值元素交换，然后return重合位置的下标,作为下一步划分左右区间的基准元素
        swap(array,begin,right);
        return begin;
    }
    //快速排序非递归实现
    /** 思路
     *采用非递归的方法，首先要想到栈的使用，通过阅读递归调用部分的代码，思考如何用栈来代替。
     *递归调用的核心代码是 getindex(array, left, right);
     *每次循环都必须包含这句核心代码，可以想到，如果要对该行代码实现循环，只能对left和right采取操作，
     *所以我们在栈中压入left和right，每个循环弹出一对left和right，用于核心代码的实现，
     *当栈空后就说明没有需要排序的部分了，结束循环。
    */
    public static void QuickSort2(int []array){
        //stack 存下标。
        Stack<Integer> stack = new Stack<>();
        //初始操作，边界入stack 的顺序和pop的顺序相反。
        stack.push(array.length-1);
        stack.push(0);
        while (!stack.isEmpty()) {
            //弹出左边界和右边界。
            int left = stack.pop();
            int right = stack.pop();
            //如果left>=rigth，说明栈里只有一个元素，则排序完成。
            if(left>=right)continue;
            //获取到基准值，将数组分为:左区间-元素全部小于基准值。右区间-元素全部大于基准值
            int index = getindex(array,left,right);
            //栈push左右区间的边界，继续处理
            // [index+1,right]为右区间
            stack.push(right);
            stack.push(index+1);
            //[left,right-1]为左区间
            stack.push(index-1);
            stack.push(left);
        }
    }

   
    public static void main(String[] args) {
        int[] array = {2,5,7,8,3,6,9};
        //InsertSort(array);
        //ShellSort(array);
        //SelectSort(array);
        //HeapSort(array);
        //BubbleSort(array);
        //QuickSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
