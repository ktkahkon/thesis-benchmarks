public class Fib1 {
   public static int i = 1;
   public static int j = 1;

    public static void main(String[] args) {
			Thread thread1 = new Thread() {
        public void run() {
           int k = 0;
           for (k = 0; k < 4; k++)
             i = i + j;
        }
      };

			Thread thread2 = new Thread() {
        public void run() {
					int k = 0;
           for (k = 0; k < 4; k++)
             j = j + i;
        }
      };

		thread1.start();
		thread2.start();

    if (i > 377 || j > 377)
      System.out.println("ERROR");


    }
}
