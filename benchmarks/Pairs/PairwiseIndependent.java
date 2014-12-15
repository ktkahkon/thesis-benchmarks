public class PairwiseIndependent {
    public static int sharedValue1 = 0;
    public static int sharedValue2 = 0;
    public static int sharedValue3 = 0;
    public static int sharedValue4 = 0;
    public static int sharedValue5 = 0;
    public static int sharedValue6 = 0;
		
    public void initializeGlobalState() {
         sharedValue1 = 0;
     sharedValue2 = 0;
    sharedValue3 = 0;
    sharedValue4 = 0;
    sharedValue5 = 0;
    sharedValue6 = 0;
    }

    public void test() {
        Thread thread = new Thread() {
            @Override
            public void run()
            {
								sharedValue1 = 1;
                int x = org.sedd.Input.generateInteger();
                if (x > 0)
                  x = 1664325;				
                else
                  x = 2455525;
            }
        };

				Thread thread2 = new Thread() {
            @Override
            public void run()
            {
								sharedValue1 = 2;
                int x = org.sedd.Input.generateInteger();
                if (x > 0)
                  x = 1664325;				
                else
                  x = 2455525;
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run()
            {
								sharedValue2 = 1;
                int x = org.sedd.Input.generateInteger();
                if (x > 0)
                  x = 1664325;				
                else
                  x = 2455525;
            }
        };

				Thread thread4 = new Thread() {
            @Override
            public void run()
            {
								sharedValue2 = 2;
                int x = org.sedd.Input.generateInteger();
                if (x > 0)
                  x = 1664325;				
                else
                  x = 2455525;
            }
        };

        Thread thread5 = new Thread() {
            @Override
            public void run()
            {
								sharedValue3 = 3;
                int x = org.sedd.Input.generateInteger();
                if (x > 0)
                  x = 1664325;				
                else
                  x = 2455525;
            }
        };

				Thread thread6 = new Thread() {
            @Override
            public void run()
            {
								sharedValue3 = 3;
                int x = org.sedd.Input.generateInteger();
                if (x > 0)
                  x = 1664325;				
                else
                  x = 2455525;
            }
        };

        Thread thread7 = new Thread() {
            @Override
            public void run()
            {
								sharedValue4 = 4;
                int x = org.sedd.Input.generateInteger();
                if (x > 0)
                  x = 1664325;				
                else
                  x = 2455525;
            }
        };

				Thread thread8 = new Thread() {
            @Override
            public void run()
            {
								sharedValue4 = 4;
                int x = org.sedd.Input.generateInteger();
                if (x > 0)
                  x = 1664325;				
                else
                  x = 2455525;
            }
        };

       

				thread.start();
        thread2.start();
				thread3.start();
        thread4.start();
				thread5.start();
        thread6.start();
			//	thread7.start();
      //  thread8.start();
    }
}
