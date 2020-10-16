public class myHashMap {
    //通过开散列处理哈希冲突
    //开散列：又叫链地址法、开链法。首先对关键码集合用哈希函数计算哈希地址，具有相同哈希地址的关键码归于同一子集合中，
    // 每一个子集合称为一个桶，各个桶中的元素通过一个单链表的方式链接起来（可以头插的方式将桶中元素链接起来），
    // 链表的第一个节点存放在哈希表中。
    static class Node{
        public int key;
        public int value;
        public Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
        //array就是hash表的本体，数组的每个元素又是一个链表的头节点
        private Node[] array = new Node[101];
        //表示当前链表的头节点
        private int size = 0;

        //定义哈希函数，将key映射为数组下标
        public int hashfun(int n){
            return n % array.length;
        }

        //若k存在，就修改value
        //若不存在，就插入新key,value
        public void put(int key,int value){
            //1.把要插入的key映射为数组下标，开始查找
            int index = hashfun(key);
            //2.根据下标找到对应的链表头节点
            Node list = array[index];
            for(Node cur = list; cur != null ; cur = cur.next){
                //3.遍历链表，存在key就修改value
                if(cur.key == key){
                    cur.value = value;
                }
            }
            //遍历结束，若不存在key，就头插到指定链表
            Node newNode = new Node(key,value);
            newNode.next = list;
            //头插完成，把对应映射的链表头改为新插入的节点。
            array[index] = newNode;
            size++;
        }

        //根据key查找对应value，找到返回value，没找到返回null
        public Integer find(int key){
            //1.把要插入的key映射为数组下标，开始查找
            int index = hashfun(key);
            //2.根据下标找到对应的链表头节点
            Node list = array[index];
            for(Node cur = list; cur != null ; cur = cur.next){
                //3.遍历链表，找到key返回value
                if(cur.key == key){
                    return cur.value;
                }
            }
            return null;
        }

        //删除key
        public boolean remove(int key){
            //1.把要插入的key映射为数组下标，开始查找
            int index = hashfun(key);
            //2.根据下标找到对应的链表头节点
            Node list = array[index];
            //parent 为cur的父节点，删除的时候直接让parent.next=cur.next即可
            Node parent = null;
            Node cur = list;
            while (cur != null) {
                //3.遍历链表，找到key就删除
                if (cur.key == key) {
                    parent.next = cur.next;
                    return true;
                }
                parent = cur;
                cur = cur.next;
            }
            //没找到key 就return false;
            return false;
        }
    }
}
