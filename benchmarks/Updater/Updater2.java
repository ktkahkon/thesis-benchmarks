import java.util.concurrent.locks.ReentrantLock;

public class Updater2 {
    public static int arr1 = 0;
    public static int arr2 = 0;
    public static int arr3 = 0;

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            public void run() {

                for (int i = 0; i < 2; i++) {
                    int selection = org.sedd.Input.generateInteger();
                    if (selection == 1) {
                        lock1.lock();
                        arr1 = org.sedd.Input.generateInteger();
                        lock1.unlock();
                    } else {
                        lock2.lock();
                        arr2 = org.sedd.Input.generateInteger();
                        lock2.unlock();
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                for (int i = 0; i < 1; i++) {
                    int selection = org.sedd.Input.generateInteger();
                    if (selection == 1) {
                        lock1.lock();
                        arr1 = arr1 + org.sedd.Input.generateInteger();
                        lock1.unlock();
                    } else {
                        lock2.lock();
                        arr2 = arr2 + org.sedd.Input.generateInteger();
                        lock2.unlock();
                    }
                }
            }
        };

        Thread thread3 = new Thread() {
            public void run() {
                int value = org.sedd.Input.generateInteger();
                lock1.lock();
                lock2.lock();

                if (arr1 == value) {
                    arr2 = arr2 * arr1;
                    arr1 = 0;
                }

                if (arr2 == value)
                    arr2 = 0;

                lock2.unlock();
                lock1.unlock();
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 0; i < 2; i++) {
            int value = org.sedd.Input.generateInteger();
            lock2.lock();
            lock1.lock();

            if (arr1 == value) {
                arr2 = arr2 + arr1;
                arr1 = 0;
            }

            if (arr2 == value)
                arr2 = 0;

            lock1.unlock();
            lock2.unlock();
        }
    }
}
