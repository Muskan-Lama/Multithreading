public class Answer1 implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Answer1 answer1 = new Answer1();
        Method1(answer1);
    }
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            System.out.printf("Start of %s\n",name);
            Thread.sleep(15000);
            System.out.printf("End of %s\n",name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void Method1(Answer1 answer1) throws InterruptedException {
        Thread thread=new Thread(answer1,"Thread 1");
        Thread thread2=new Thread(answer1,"Thread 2");



             thread2.start();
             //waiting till till thread2 will finish its job
             thread2.join();

             thread.start();




    }

}






