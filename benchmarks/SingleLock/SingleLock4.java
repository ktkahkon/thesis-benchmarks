import java.util.concurrent.locks.ReentrantLock;

public class SingleLock4 {
    public static int sharedValue = 0;
    public static int sharedValue2 = 0;
    public static int sharedValue3 = 0;

    public static ReentrantLock lock1 = new ReentrantLock();

    public static void main(String[] args) {
			Thread thread1 = new Thread() {
        public void run() {
					lock1.lock();
          sharedValue = 1;
          sharedValue2 = 4; 
          sharedValue3 = 5;
          int x = sharedValue;
					lock1.unlock();

					lock1.lock();
					sharedValue = 2;
          int y = sharedValue3;
					lock1.unlock();
        }
      };

			Thread thread2 = new Thread() {
        public void run() {
					lock1.lock();
					sharedValue = 2;
          int x = sharedValue3;
					lock1.unlock();

					lock1.lock();
          sharedValue = 1;
          sharedValue2 = 4; 
          sharedValue3 = 5;
          int y = sharedValue;
					lock1.unlock();
        }
      };

			Thread thread3 = new Thread() {
        public void run() {
					lock1.lock();
					sharedValue = 3;
          int x = sharedValue2;
					lock1.unlock();

					lock1.lock();
          sharedValue = 1;
          sharedValue2 = 4; 
          sharedValue3 = 5;
          int y = sharedValue;
					lock1.unlock();
        }
      };

			Thread thread4 = new Thread() {
        public void run() {
					lock1.lock();
          sharedValue2 = 1;
          sharedValue = 4; 
          sharedValue3 = 5;
          int x = sharedValue2;
					lock1.unlock();

					lock1.lock();
					sharedValue = 2;
          int y = sharedValue;
					lock1.unlock();
        }
      };

			Thread thread5 = new Thread() {
        public void run() {
					lock1.lock();
          sharedValue = 1;
          sharedValue2 = 4; 
          sharedValue3 = 5;
          int x = sharedValue2;
					lock1.unlock();

          lock1.lock();
          sharedValue = 1;
          sharedValue2 = 4; 
          sharedValue3 = 5;
          int y = sharedValue;
					lock1.unlock();
        }
      };

      Thread thread6 = new Thread() {
        public void run() {
					lock1.lock();
					sharedValue = 3;
          int x = sharedValue2;
          int z = sharedValue3;
					lock1.unlock();

					lock1.lock();
          sharedValue = 1;
          sharedValue2 = 4; 
          sharedValue3 = 5;
          int y = sharedValue;
					lock1.unlock();
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
