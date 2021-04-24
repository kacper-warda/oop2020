package wsb.threads;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableCounter implements Callable<Double> {

    static final public Integer START_FROM = 3;

    @Override
    public Double call() throws Exception {
        for(int i = START_FROM; i >=0; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
        return new Random().nextDouble();
    }
}
