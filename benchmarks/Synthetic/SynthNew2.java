import java.util.concurrent.locks.ReentrantLock;

public class SynthNew2 {
    public static int sharedValue = 0;
    public static int sharedValue2 = 0;
    public static int sharedValue3 = 0;

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();


    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            public void run() {
                sharedValue = org.sedd.Input.generateInteger();
                int read2 = sharedValue2;
                int read3 = sharedValue3;
				
                if (read3 + read2 > sharedValue) {
                    lock1.lock();
                    lock2.lock();

                    read2 = read2 * 5;
                    sharedValue3 = read2;

                    lock2.unlock();
                    lock1.unlock();
                }
            }
        };


        Thread thread2 = new Thread() {
           public void run() {
               sharedValue3 = org.sedd.Input.generateInteger();
           }
        };

        Thread thread4 = new Thread() {
            public void run() {
            int i = org.sedd.Input.generateInteger();
            
            if (i > sharedValue3 % 48)
		           sharedValue2 = i;
          }
        };


        Thread thread3 = new Thread() {
            public void run() {
                 int l = org.sedd.Input.generateInteger();
                 int r = sharedValue;
                 int r2 = sharedValue3;
                 if (l == r + r2) {
                    sharedValue2 = l;
                 }    
            }
        };
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        int read1 = sharedValue;
        sharedValue2 = 1;

        if (org.sedd.Input.generateInteger() > 10) {
            int x = sharedValue3;
        }
        else {
           lock2.lock();
           lock1.lock();
           lock1.unlock();
           lock2.unlock();
        }

    }
}
