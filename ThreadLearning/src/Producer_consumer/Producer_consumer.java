package Producer_consumer;

//默认生产者：一次生产3个
//默认消费者：一次消费1个
public class Producer_consumer {
    //总量：上限100，下限0
    public static volatile int SUM;

    public static void main(String[] args) {
        //启动生产者5个
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(), "生产者" + i).start();
        }
        //启动消费者5个
        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer(), "消费者" + i).start();
        }
    }

    private static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                //总生产20次
                for (int i = 0; i < 20; i++) {
                    synchronized (Producer_consumer.class) {
                        while (SUM + 3 > 100) {  //下次生产完库存不能大于100
                            Producer_consumer.class.wait();
                        }
                        //开始生产
                        SUM += 3;
                        //模拟休息
                        Thread.sleep(100);
                        //notify/notifyAll通知因调用wait阻塞的线程，notify随机唤醒，notifyAll唤醒全部
                        //synchronized代码块结束，也就是释放对象锁之后才会唤醒
                        //也就是说，synchronized代码块结束，wait 和 synchronized阻塞的线程都会被唤醒
                        Producer_consumer.class.notifyAll();
                        System.out.println(Thread.currentThread().getName() + "生产3，库存为：" + SUM);
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (Producer_consumer.class) {
                        //库存为0，当前线程不能消费，进入阻塞
                        while (SUM == 0) {
                            //释放对象锁，让其他线程继续运行，当前线程阻塞
                            Producer_consumer.class.wait();
                        }
                        SUM--;
                        //模拟休息
                        Thread.sleep(100);
                        Producer_consumer.class.notifyAll();
                        System.out.println(Thread.currentThread().getName() + "消费1，库存为：" + SUM);
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
