package com.geektcp.id;

import com.geektcp.common.core.util.IdUtils;

public class App {
    public static void main(String[] args) {
        multiThread();
    }

    private static void singleGen(){
        for (int i =0; i<1000;i++){
            System.out.println(IdUtils.getId());
        }
    }

    private static void multiThread(){
        new Thread(()->{
            for (int i =0; i<1000;i++){
                System.out.println(IdUtils.getId("A"));
            }
        },"A").start();

        new Thread(()->{
            for (int i =0; i<1000;i++){
                System.out.println(IdUtils.getId("B"));
            }
        },"A").start();

    }


}
