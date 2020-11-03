package BlockingQueue;

/**
 * 实现阻塞式队列：
 * 1.满足线程安全的消费，生产功能
 * 2.消费/生产达到下限/上限需阻塞等待
 */
public class MyBlockingQueue<E> {
    Object[] items;  //阻塞队列
    private int putindex;  // 添加元素
    private int takeindex; //弹出元素
    private int size; // 有效容量

    public MyBlockingQueue(int capcity){  //初始化容量
        items = new Object[capcity];
    }



    //入队操作
    private synchronized void put(E e) throws InterruptedException {
        while (size == items.length){  //达到上限，需阻塞等待
            wait();
        }
        putindex = (putindex + 1) % items.length;  //存放元素的索引。由于为循环队列，要防止越界
        items[putindex] = e;  //存放元素
        size ++; //有效容量++
        notifyAll(); // 通知
    }


    //出队操作
    private synchronized E take() throws InterruptedException {
        while ( size == 0){  //达到下限，需阻塞等待
            wait();
        }
        takeindex = (takeindex + 1) % items.length;
        size--;
        notifyAll(); // 通知
        return (E) items[takeindex];
    }

    private static int SUM; //产品库存
    //生产者
    private static class Producer implements Runnable{
        @Override
        public void run() {
            SUM += 3;
            System.out.println(Thread.currentThread().getName() + "生产3，库存为：" + SUM);
        }
    }

    //消费者
    private static class Consumer implements Runnable {
        @Override
        public void run() {
            SUM -= 1;
            System.out.println(Thread.currentThread().getName() + "消费1，库存为：" + SUM);
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<Runnable>  queque = new MyBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            //开启5线程，每个线程都生产3个产品
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            queque.put(new Producer());  //可以理解为每个线程生产的任务，加到阻塞队列里
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            queque.put(new Consumer());  //可以理解为每个线程消费的任务，加到阻塞队列里
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
