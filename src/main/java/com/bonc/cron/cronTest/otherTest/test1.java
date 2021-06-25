package com.bonc.cron.cronTest.otherTest;


import com.bonc.cron.cronTest.ceainject.entity.CEAInfoPO;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhengHang
 * @create 2021-06-10 15:57
 */
public class test1 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        for (int i = 0 ; i < 10 ; i++) {
            CEAInfoPO ceaInfoPO = new CEAInfoPO( i,"123", "127.0.0.1:9372", new Date(), "test", 1);
            String context = "context" + i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() +", ceaInfo = " + ceaInfoPO + ", context = " + context);
                }
            });
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
