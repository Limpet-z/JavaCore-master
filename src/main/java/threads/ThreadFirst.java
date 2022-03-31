package threads;

import java.util.concurrent.TimeUnit;

public class ThreadFirst {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        ThreadGroup threadGroup = currentThread.getThreadGroup();
        System.out.println("Thread: " + currentThread.getName());
        System.out.println("Thread Group: " + threadGroup.getName());
        System.out.println("Parent Group: " + threadGroup.getParent().getName());

        Thread th = Thread.currentThread();

        th.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }
        });
        System.out.println(2 / 0);
    }
}

class Hello {
    public static void main(String[] args) {

        Runnable task = () -> System.out.println("XXX");

         Thread thread = new Thread(task);
         thread.start();
         Thread thread1 = new Thread(task);
         thread1.start();

        ThreadGroup threadGroup = thread.getThreadGroup();

        System.out.println("Thread: " + thread.getName());
        System.out.println("Thread1: " + thread1.getName());
        System.out.println("Thread Group: " + threadGroup.getName());
    }

}

class Hello1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () ->
        {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };

        Thread thread = new Thread(task);
            thread.start();
            thread.join();
        System.out.println("Finished");
    }
}

class  H {
    public static void main(String[] args) throws InterruptedException {
       Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {

                System.out.println("thread");
            }
        };

        Thread th1 = new Thread(task);
        th1.start();
        synchronized (lock) {
            for (int i = 0; i < 8; i++) {
                Thread.sleep(1000);
                System.out.print("  " + i);
            }
            System.out.println(" ...");
        }
    }
}
