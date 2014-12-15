public class FileSystem2 {
    static final int THREADS = 20;

    public static final Object[] locki = new Object[32];
    public static final int[] inode = new int[32];
    public static final Object[] lockb = new Object[26];
    public static final boolean[] busy = new boolean[26];

    static {
        for (int i = 0; i < 32; ++i) {
            locki[i] = new Object();
            if (i < 26)
                lockb[i] = new Object();
        }
    }

    public static void main(String[] args) {
        for (int k = 0; k < THREADS; ++k) {
            final int i = k % 32;
            new Thread() {
                public void run() {
                    synchronized(locki[i]) {
                        if (inode[i] == 0) {
                            int b = (i * 2) % 26;
                            while (true) {
                                synchronized(lockb[b]) {
                                    if (!busy[b]) {
                                        busy[b] = true;
                                        inode[i] = b+1;
                                        break;
                                    }
                                }
                                b = (b + 1) % 26;
                            }
                        }
                    }
                }
            }.start();
        }
    }
}
