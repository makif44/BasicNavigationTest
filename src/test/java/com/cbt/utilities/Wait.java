package com.cbt.utilities;

public class Wait {
    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
