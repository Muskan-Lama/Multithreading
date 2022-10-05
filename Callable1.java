import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Callable1 implements Callable<String> {
    public String call() throws Exception{
        return "Hello World!";
    }
}
class An implements Runnable
{
    public void run()
    {
        System.out.println("Hello world ! of Runnable ");
    }
}
class CallableExample {
     static ExecutorService executor = Executors.newFixedThreadPool(2);

     public static void main(String[] args) throws Exception {
         Callable1 task = new Callable1();
         An a=new An();
         Thread thread=new Thread(a);
         ExecutorService executorService=Executors.newSingleThreadExecutor();

         executorService.execute(a);

         Future<String> message = executor.submit(task);
         System.out.println(message.get().toString());


     }

 }
