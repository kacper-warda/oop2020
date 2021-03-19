package wsb.thread;

public class RunnableCounter implements Runnable {

    public static final Integer COUNT_FROM = 10;

    @Override
    public void run() {
        for(int i = COUNT_FROM; i>=0;i--){
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
