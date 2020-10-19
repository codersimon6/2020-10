package UnsafeThread;

public class UnsafeThread {
    private static int COUNT;
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0;j < 10000;j++){
                        COUNT++;
                    }
                }
            });
            t.start();
        }
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(COUNT);
    }
}
