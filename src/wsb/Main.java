package wsb;

import wsb.thread.RunnableCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args)  {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        executor.submit(new RunnableCounter());
        executor.submit(new RunnableCounter());


        executor.shutdown();

    }

}
