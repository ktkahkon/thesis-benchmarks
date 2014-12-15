import java.util.concurrent.locks.ReentrantLock;

public class SynthNew implements Runnable {
    public static int sharedValue = 0;
    public static int sharedValue2 = 0;
    public static int sharedValue3 = 0;

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    public void run() {
        sharedValue3 = 1;
        sharedValue2 = org.sedd.Input.generateInteger();
        int read2 = sharedValue2;
        int read3 = sharedValue3;
				
				if (read3 + read2 > 10) {
           lock1.lock();
           lock2.lock();

           read2 = read2 * 5;
           sharedValue3 = read2;

           lock2.unlock();
           lock1.unlock();
        }

    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new SynthNew());
        thread1.start();

        Thread thread2 = new Thread(new SynthNew());
        thread2.start();

        int read1 = sharedValue;
        sharedValue2 = 1;

        if (org.sedd.Input.generateInteger() > 10) {
            int x = 0;
        }
        else {
           lock2.lock();
           lock1.lock();
           lock1.unlock();
           lock2.unlock();
        }
    }
}
