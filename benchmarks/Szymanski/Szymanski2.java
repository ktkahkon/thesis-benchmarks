public class Szymanski2 {
   public static int flag1 = 0;
   public static int flag2 = 0;
   public static int x = 0;

    public void initializeGlobalState() {
				flag1 = 0;
    	  flag2 = 0;
        x = 0;
    }

    public static void main(String[] args) {
			Thread thread1 = new Thread() {
        public void run() {
            int iterations = 0;
            flag1 = 1;
            while (flag2 >= 3 && iterations < 4) {iterations++;} 
            flag1 = 3;

            if (flag2 == 1) {
                flag1 = 2;
                while (flag2 != 4 && iterations < 3) {iterations++;}
            }

            flag1 = 4;
            while (flag2 >= 2 && iterations < 3) {iterations++;}
            x = 0;
            if (x>0) {}

            while (flag2 >= 2 && flag2 <= 3 && iterations < 4) {iterations++;}
            flag1 = 0;
        }
    };

      Thread thread2 = new Thread() {
        public void run() {
            int iterations = 0;
            flag2 = 1;
            while (flag1 >= 3 && iterations < 4) {iterations++;}
            flag2 = 3;

            if (flag1 == 1) {
                flag2 = 2;
                while (flag1 != 4 && iterations < 3) {iterations++;}
            }

            flag2 = 4;
            while (flag1 >= 2 && iterations < 3) {iterations++;}
            x = 1;

            if (x<1) {}

            while (flag1 >= 2 && flag1 <= 3 && iterations < 4) {iterations++;}
            flag2 = 0;
         }
      };

		  thread1.start();
		  thread2.start();
  }
}
