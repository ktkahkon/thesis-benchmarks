import java.util.concurrent.locks.ReentrantLock;

public class Dining1 {
    private static ReentrantLock fork1 = new ReentrantLock();
    private static ReentrantLock fork2 = new ReentrantLock();
    private static ReentrantLock fork3 = new ReentrantLock();
    private static ReentrantLock fork4 = new ReentrantLock();

    public static void main(String[] args) {
			Thread thread1 = new Thread() {
        public void run() {
          fork1.lock();
          fork4.lock();
          // EAT
          fork4.unlock();
          fork1.unlock();
          
          fork1.lock();
          fork4.lock();
          // EAT
          fork4.unlock();
          fork1.unlock();
        }
      };

			Thread thread2 = new Thread() {
        public void run() {
          fork2.lock();
          fork1.lock();
          // EAT
          fork1.unlock();
          fork2.unlock();
          
          fork2.lock();
          fork1.lock();
          // EAT
          fork1.unlock();
          fork2.unlock();
        }
      };

			Thread thread3 = new Thread() {
        public void run() {
          fork3.lock();
          fork2.lock();
          // EAT
          fork2.unlock();
          fork3.unlock();
          
          fork3.lock();
          fork2.lock();
          // EAT
          fork2.unlock();
          fork3.unlock();					
        }
      };

			Thread thread4 = new Thread() {
        public void run() {
          fork4.lock();
          fork3.lock();
          // EAT
          fork3.unlock();
          fork4.unlock();
          
          fork4.lock();
          fork3.lock();
          // EAT
          fork3.unlock();
          fork4.unlock();			
        }
      };


		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

    }
}
