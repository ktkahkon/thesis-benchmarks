public class PiJavaThread {
  static final int THREADS = 3;

  int n, numThreads;
  double pi = 0.0;
  synchronized void addPi(double p) {
    pi += p;
  }
  public PiJavaThread(int nd, int nt) {
    n = nd;
    numThreads = nt;
    Thread threads[] = new Thread[numThreads];
    for (int i=0; i<numThreads; i++) {
      threads[i] = new Thread(new PIworker(i));
      threads[i].start();
    }

    if (nt < -100)
        System.out.println("dummy branch for jCUTE");
  }
  class PIworker implements Runnable {
    int myid;
    public PIworker(int id) {
      myid = id;
    }
    public void run() {
      double d, s, x;
      d = 1.0/n;
      s = 0.0;
      for (int i=myid+1; i<=n; i+=numThreads) {
        x = (i-0.5)*d;
        s += 4.0/(1.0+x*x);
      }
      addPi(d*s);
    }
  }
  public static void main(String[] args) {
    PiJavaThread piJavaThread = new PiJavaThread(3,THREADS);
  }
}
