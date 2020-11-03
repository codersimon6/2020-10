package JoinTest;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        //无参构造表示引用join()的线程，等待被引用线程运行结束再运行
        //t.join();
        //带参构造表示引用join(time)的线程，在满足以下条件之一后开始运行。
        //条件1. 等够了time时间
        //条件2. 被引用线程运行结束
        t.join(2000);
        System.out.println(Thread.currentThread().getName());
    }
}
