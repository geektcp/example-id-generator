package com.geektcp.id;

import com.geektcp.common.core.generator.IdGenerator;

public class App {
    public static void main(String[] args) {
        base();
        singleGen();
        multiThread();
    }


    private static void base() {
        long a = 0;
        String c = null;

        a = IdGenerator.getId();
        System.out.println(a);
        a = IdGenerator.getId(1, 3);

        System.out.println(a);
        IdGenerator.setSplit("/");
        c = IdGenerator.getId("PRE");

        System.out.println(c);
        IdGenerator.setInstance(10, 0);

        a = IdGenerator.getId();

        System.out.println(a);
    }


    private static void singleGen() {
        for (int i = 0; i < 100; i++) {
            System.out.println(IdGenerator.getId());
        }
    }

    private static void multiThread() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(IdGenerator.getId("A"));
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(IdGenerator.getId("B"));
            }
        }, "A").start();

    }


}
