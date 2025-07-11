package org.sammo.java_collections_framework.map;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapPractice {

    public static void main(String[] args) {

        /*
        A Skip List is a data structure that allows fast search, insertion, and deletion operations
        — similar to a balanced tree like a Red-Black Tree — but is simpler and more efficient for
        concurrent access. It works by maintaining multiple layers of linked lists, where each higher
        layer acts like an "express lane" to skip over elements in the layer below.

        Level 3:        1 ----------- 9
        Level 2:        1 ---- 5 ---- 9 ---- 13
        Level 1:        1 -- 3 -- 5 -- 7 -- 9 -- 11 -- 13 -- 15

        Search Example:
        Let’s search for 11:
        Start at the top level (Level 3), at node 1.
        Move to 9. Can’t go further (next is null or >11).
        Drop to Level 2 at 9, move to 13 — too big!
        Drop to Level 1, go to 11

        Insert Example:
        Inserting 8:
        Insert it into Level 0 (basic sorted linked list).
        Then randomly decide (using coin toss) whether to include it in higher levels.
        If heads, promote it to Level 1.
        Another heads? Promote to Level 2, and so on.

        This randomness gives it average-case O(log n) performance for insertions, deletions, and searches. */

        ConcurrentSkipListMap<Integer, String> concurrentSkipListMap = new ConcurrentSkipListMap<>((i1, i2) -> i2 - i1);

        Thread writer1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                concurrentSkipListMap.put(i, "Writer1-Val: " + i);
                System.out.println("Writer1 → inserted: " + i);
                try {
                    Thread.sleep(100); // simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Writer1");

        Thread writer2 = new Thread(() -> {
            for (int i = 10; i <= 20; i++) {
                concurrentSkipListMap.put(i, "Writer2-Val: " + i);
                System.out.println("Writer2 → inserted: " + i);
                try {
                    Thread.sleep(100); // simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Writer2");

        Thread reader = new Thread(() -> {
            while (true) {
                System.out.println("Reader → Current Map: " + concurrentSkipListMap);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }, "Reader");

        writer1.start();
        writer2.start();
        reader.start();

        try {
            writer1.join();
            writer2.join();
            Thread.sleep(1000); // let reader finish reading final state
            reader.interrupt(); // stop the reader thread gracefully
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n Final Map (sorted): " + concurrentSkipListMap);

        /*
        Two writer threads insert values concurrently.
        One reader thread keeps reading the map while inserts are happening.
        Despite the concurrency, the map remains sorted, consistent, and thread-safe.
        Output order is based on key sorting (because ConcurrentSkipListMap maintains natural order). */
    }
}
