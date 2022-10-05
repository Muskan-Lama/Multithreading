public class Practice1 extends Thread {

    public static void main(String[] args) throws InterruptedException {

        Practice1 p = new Practice1();
        method1(p);
    }
    public  void run()
    {
        String name = Thread.currentThread().getName();
        try {
            System.out.printf("Start of %s\n",name);
            Thread.sleep(1000);
            System.out.printf("End of %s\n",name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public static void method1(Practice1 practice1) throws InterruptedException {
        Thread t1=new Thread(practice1,"THREAD 1 ");
        Thread t2=new Thread(practice1,"THREAD 2");


        t1.start();
        t1.join();
        t2.start();
    }


    }
