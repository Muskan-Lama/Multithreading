import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public class fixedThreadPoolExample {
        public static void main(String[] args) {
            System.out.println("Main thread starts here.");
            ExecutorService service = Executors.newFixedThreadPool(3);
            for (int i = 0; i < 6; i++) {
                service.execute(new Task());
            }
            service.shutdown();
            System.out.println("Main thread ends here.");
        }
    }
}