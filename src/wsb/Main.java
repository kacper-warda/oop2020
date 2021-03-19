package wsb;

import wsb.thread.CallableCounter;
import wsb.thread.Finisher;
import wsb.thread.RunnableCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);


        Future<Double> future1  = executor.submit(new CallableCounter());
        Future<Double> future2  = executor.submit(new CallableCounter());


        executor.shutdown();
        System.out.println("Test1");
        System.out.println(future1.get());
        System.out.println("Test2");
        System.out.println(future2.get());
        System.out.println("Test3");
    }

}
