package MyThread;

public class MyThread {
    //通过实现 Runnable 接口，并且调用 Thread 的构造方法时将 Runnable 对象作为 target 参数传入来创建线程对象
    //该方法的好处是可以规避类的单继承的限制；但需要通过 Thread.currentThread() 来获取当前线程的引用。
    public static void main(String[] args) {
        Thread t = new Thread(new myRunnable());
        t.start();
    }
  static class myRunnable implements Runnable {
      @Override
      public void run() {
          System.out.println(Thread.currentThread().getName()+"在运行");
      }
  }
}

//可以通过继承 Thread 来创建一个线程类，该方法的好处是 this 代表的就是当前线程，不需要通过
//    //Thread.currentThread() 来获取当前线程的引用。
//    public static void main(String[] args) {
//        Thread2 t = new Thread2();
//        t.start();
//    }
//
//    static class Thread2 extends Thread {
//        @Override
//        public void run() {
//            //打印当前进程名字（如自己没设置名字，系统默认生成）
//            System.out.println(currentThread().getName());
//        }
//    }

