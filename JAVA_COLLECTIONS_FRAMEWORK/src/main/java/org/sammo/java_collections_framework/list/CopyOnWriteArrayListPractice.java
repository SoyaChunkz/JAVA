package org.sammo.java_collections_framework.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListPractice {

    public static void main(String[] args) {

//        ArrayList<String> shoppingList = new ArrayList<>(Arrays.asList("Milk", "Eggs", "Bread"));
//        CopyOnWriteArrayList<String> shoppingList = new CopyOnWriteArrayList<>(Arrays.asList("Milk", "Eggs", "Bread"));
//
//        System.out.println("Iterating on: ");
//
//        for (String item : shoppingList) {
//            System.out.println(item);
//            if (item.equals("Eggs")) {
//                shoppingList.add("SoyaChunkz");
//                System.out.println("...Added SoyaChunkz while reading");
//            }
//        }
//
//        System.out.println("Updated List: " + shoppingList);
 /*
 *
 *
 *
 *
 *
 *
 *
 * */

//        List<String> sharedList = new ArrayList<>();
        List<String> sharedList = new CopyOnWriteArrayList<>();
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");

        Thread readerThread = new Thread(() -> {
            while (true) {
                for (String item : sharedList) {
                    System.out.println("Reading: " + item);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "readerThread");

        Thread writerThread = new Thread(()-> {
            try{
                Thread.sleep(500); // allow reading to start first
                sharedList.add("Item4");
                System.out.println("...Added Item4");

                sharedList.remove("Item1");
                System.out.println("...Removed Item1");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, "writerThread");

        readerThread.start();
        writerThread.start();
    }
}
