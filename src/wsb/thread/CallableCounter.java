package wsb.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableCounter implements Callable<Double> {
    public static final Integer COUNT_FROM = 3;
    public final String name;
    public Finisher finisher;

    public CallableCounter(String name){
        this.name = name;
    }

    @Override
    public Double call() throws Exception {
        for(int i = COUNT_FROM; i>=0;i--){
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return new Random().nextDouble();
    }
}
