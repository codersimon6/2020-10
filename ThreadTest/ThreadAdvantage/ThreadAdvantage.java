package ThreadAdvantage;

public class ThreadAdvantage {
    //线程数目
    private static final int NUM = 5;
    //计算次数
    private static final int COUNT = 10_0000_0000;
    //测试:计算 a 的值
    private static void increment(){
        int a = 0;
        for(long i = 0; i < COUNT; i++){
            a++;
        }
    }
    //串行（依次执行）
    private static void serial(){
        long start = System.nanoTime();
        for(int i = 0;i < NUM;i++){
            increment();
        }
        long end = System.nanoTime();
        System.out.printf("串行运行时间：%s毫秒",(end-start)/1000/1000);
    }

    //并发（有时候并发既表达并发，也表达并行）
    private static void parallel(){
        long start = System.nanoTime();
        for(int i = 0;i < NUM;i++) {
            //开启五个新线程，分别运行increment
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            }).start();
        }
        //若活跃线程大于1，即并发没结束，当前线程让步，继续执行并发线程
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        long end = System.nanoTime();
        System.out.printf("并发运行时间：%s毫秒",(end-start)/1000/1000);
    }

    public static void main(String[] args) {
        serial();
        System.out.println();
        parallel();
        System.out.println();
    }
}
