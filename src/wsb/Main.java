package wsb;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import wsb.creatures.*;
import wsb.database.Connector;
import wsb.database.JDBCConnector;
import wsb.devices.*;

import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args)  {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>();

        long start = System.currentTimeMillis();

        Random random = new Random();

        for (int i=0; i<2; i++)
        {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator  = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        for(Future<Integer> future : resultList)
        {
            try
            {
                System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis()-start);
        //shut down the executor service now
        executor.shutdown();
    }

    public static String updateSomeData(String newData) throws InterruptedException {
        System.out.println("function: validation of new data");
        Thread.sleep(20);
        System.out.println("function: updating data to " + newData);
        Thread.sleep(20);

        long startTime = System.currentTimeMillis();

//        Callable later = new Callable<List<Integer>>() {
//            long start = startTime;
//
//            @Override
//            public List<Integer> call() throws Exception {
//                long time = System.currentTimeMillis();
//
//                System.out.println("function: looking for users that have to be notified");
//                Thread.sleep(2000);
//                System.out.println("function: connecting to mail api (like mailgun)");
//                Thread.sleep(500);
//                System.out.println("function: sending mails");
//                Thread.sleep(10000);
//                System.out.println(System.currentTimeMillis() - this.start);
//                return 12312;
//            }
//        };

//        ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();
//        execService.schedule(later, 1, TimeUnit.SECONDS);

        return "data was updated";
    }

    private static class FactorialCalculator  implements Callable<Integer>
    {

        private Integer number;

        public FactorialCalculator(Integer number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            int result = 1;
            if ((number == 0) || (number == 1)) {
                result = 1;
            } else {
                for (int i = 2; i <= number; i++) {
                    result *= i;
                    TimeUnit.MILLISECONDS.sleep(20);
                }
            }
            Thread.sleep(5000);
            System.out.println("Result for number - " + number + " -> " + result);
            return result;
        }
    }
}
