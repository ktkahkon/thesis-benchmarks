import java.util.concurrent.locks.ReentrantLock;

public class Dining3 {
    private static ReentrantLock fork1 = new ReentrantLock();
    private static ReentrantLock fork2 = new ReentrantLock();
    private static ReentrantLock fork3 = new ReentrantLock();
    private static ReentrantLock fork4 = new ReentrantLock();
    private static ReentrantLock fork5 = new ReentrantLock();
    private static ReentrantLock fork6 = new ReentrantLock();

    public static void main(String[] args) {
			Thread thread1 = new Thread() {
        public void run() {
					fork1.lock();
					fork6.lock();
					fork6.unlock();
					fork1.unlock();

					fork1.lock();
					fork6.lock();
					fork6.unlock();
					fork1.unlock();
        }
      };

			Thread thread2 = new Thread() {
        public void run() {
					fork2.lock();
					fork1.lock();
					fork1.unlock();
					fork2.unlock();

					fork2.lock();
					fork1.lock();
					fork1.unlock();
					fork2.unlock();
        }
      };

			Thread thread3 = new Thread() {
        public void run() {
					fork3.lock();
					fork2.lock();
					fork2.unlock();
					fork3.unlock();

					fork3.lock();
					fork2.lock();
					fork2.unlock();
					fork3.unlock();
        }
      };

			Thread thread4 = new Thread() {
        public void run() {
					fork4.lock();
					fork3.lock();
					fork3.unlock();
					fork4.unlock();

					fork4.lock();
					fork3.lock();
					fork3.unlock();
					fork4.unlock();
        }
      };

			Thread thread5 = new Thread() {
        public void run() {
					fork5.lock();
					fork4.lock();
					fork4.unlock();
					fork5.unlock();

					fork5.lock();
					fork4.lock();
					fork4.unlock();
					fork5.unlock();
        }
      };

			Thread thread6 = new Thread() {
        public void run() {
					fork6.lock();
					fork5.lock();
					fork5.unlock();
					fork6.unlock();

					fork6.lock();
					fork5.lock();
					fork5.unlock();
					fork6.unlock();
        }
      };


		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
    thread6.start();

    }
}
