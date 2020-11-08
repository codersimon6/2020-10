package SafeThread;

public class synchronizedTest implements Runnable {
    //共享资源
    static int i = 0;

    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        synchronizedTest test = new synchronizedTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}

//        //共享资源
//        static int i =0;
//        /**
//         * synchronized 修饰实例/静态方法
//         */
//        public static synchronized void increase(){
//            i++;
//        }
//        @Override
//        public void run(){
//            for (int j =0 ; j<10000;j++){
//                increase();
//            }
//        }
//
//        public static void main(String[] args) throws InterruptedException {
//            Thread t1 = new Thread(new synchronizedTest());
//            Thread t2 = new Thread(new synchronizedTest());
//            t1.start();
//            t2.start();
//            t1.join();
//            t2.join();
//            System.out.println(i);
//        }

//    private static int COUNT;
//    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j = 0; j < 10000; j++) {
//                        //同步代码块，this指new的Runnable()
//                        synchronized (this){
//                            COUNT++;
//                        }
//                    }
//                }
//            });
//            t.start();
//        }
//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
//        System.out.println(COUNT);
//    }