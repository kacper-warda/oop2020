package wsb;

import wsb.thread.Finisher;
import wsb.thread.RunnableCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args)  {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        RunnableCounter counter1 = new RunnableCounter();
        counter1.finisher = () -> System.out.println("Scorpion Wins");

        RunnableCounter counter2 = new RunnableCounter();
        counter2.finisher = () -> System.out.println("SubZero Wins");

        executor.submit(counter1);
        executor.submit(counter2);


        executor.shutdown();

    }

}
