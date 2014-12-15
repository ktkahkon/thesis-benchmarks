public class Writes {
    public static int sharedValue = 0;
    public static int sharedValue2 = 0;

    public void initializeGlobalState() {
      sharedValue = 0;
      sharedValue2 = 0;
    }

   
    public void test() {

      Thread thread1 = new Thread() {
        public void run() {
          sharedValue = 1;
          sharedValue = 2;
        }
      };

      Thread thread2 = new Thread() {
        public void run() {
          sharedValue = 3;
          sharedValue = 4;
        }
      };

      Thread thread3 = new Thread() {
        public void run() {
          sharedValue = 9;
          sharedValue = 10;
        }
      };

      Thread thread4 = new Thread() {
        public void run() {
          sharedValue = 11;
          sharedValue = 12;
        }
      };

      Thread thread5 = new Thread() {
        public void run() {
          sharedValue = 7;
          sharedValue = 8;
        }
      };

        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


        sharedValue = 5;
        sharedValue = 6;

    }
}
