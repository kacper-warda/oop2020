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

        CallableCounter counter1 = new CallableCounter("SubZero");
        counter1.finisher = () -> System.out.println("YOU ARE FROZEN!!!");

        CallableCounter counter2 = new CallableCounter("Scorpion");
        counter2.finisher = () -> System.out.println("YOU ARE POISONED!!!");

        Future<Double> future1 = executor.submit(counter1);
        Future<Double> future2 = executor.submit(counter2);

        executor.shutdown();

        if (future1.get() > future2.get()) {
            counter1.finisher.finishHim();
        } else {
            counter2.finisher.finishHim();
        }
    }

}
