package cli;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BlackholeCalc {

    public static void calculateBlackHole(){
        Random r = new Random();
        for(int i=0; i<40;i++){
            for(int o=0; o<100;o++){
                System.out.print(r.nextInt(10));
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
        for(int i=0; i<5000; i++){
            String uuid = UUID.randomUUID().toString()+UUID.randomUUID().toString();
            System.out.println(uuid);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
