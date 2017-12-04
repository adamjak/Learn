package net.adamjak.tomas.learn.listMapTests;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

public class ListTestRunner extends ListMapTest {

    public ListTestRunner() {
    }

    LinkedHashMap<String,Long> run() {
        String[] arr = new String[this.getValues()];
        for (int i = 0; i < this.getValues(); i++) {
            arr[i] = UUID.randomUUID().toString();
        }

        long arrayListInsertSum = 0;
        long linkedListInsertSum = 0;
        long vectorInsertSum = 0;

        long arrayListGetByIndexSum = 0;
        long linkedListGetByIndexSum = 0;
        long vectorGetByIndexSum = 0;

        long arrayListGetByIterSum = 0;
        long linkedListGetByIterSum = 0;
        long vectorGetByIterSum = 0;

        for (int r = 0; r < this.getRuns(); r++) {
            ArrayList<String> arrayList = new ArrayList<String>();
            long arrayListInsertStart = System.nanoTime();
            for (int i = 0; i < arr.length; i++) {
                arrayList.add(arr[i]);
            }
            long arrayListInsertStop = System.nanoTime();
            arrayListInsertSum += arrayListInsertStop - arrayListInsertStart;

            long arrayListGetByIndexStart = System.nanoTime();
            String s1 = "";
            for (int i = 0; i < arr.length; i++) {
                s1 = arrayList.get(i);
            }
            long arrayListGetByIndexStop = System.nanoTime();
            arrayListGetByIndexSum += arrayListGetByIndexStop - arrayListGetByIndexStart;

            long arrayListGetByIterStart = System.nanoTime();
            String s2 = "";
            for (String s : arrayList) {
                s2 = s;
            }
            long arrayListGetByIterStop = System.nanoTime();
            arrayListGetByIterSum += arrayListGetByIterStop - arrayListGetByIterStart;
        }

        for (int r = 0; r < this.getRuns(); r++) {
            LinkedList<String> linkedList = new LinkedList<String>();
            long linkedListInsertStart = System.nanoTime();
            for (int i = 0; i < arr.length; i++) {
                linkedList.add(arr[i]);
            }
            long linkedListInsertStop = System.nanoTime();
            linkedListInsertSum += linkedListInsertStop - linkedListInsertStart;

            long linkedListGetByIndexStart = System.nanoTime();
            String s1 = "";
            for (int i = 0; i < arr.length; i++) {
                s1 = linkedList.get(i);
            }
            long linkedListGetByIndexStop = System.nanoTime();
            linkedListGetByIndexSum += linkedListGetByIndexStop - linkedListGetByIndexStart;

            long linkedListGetByIterStart = System.nanoTime();
            String s2 = "";
            for (String s : linkedList) {
                s2 = s;
            }
            long linkedListGetByIterStop = System.nanoTime();
            linkedListGetByIterSum += linkedListGetByIterStop - linkedListGetByIterStart;
        }

        for (int r = 0; r < this.getRuns(); r++) {
            Vector<String> vector = new Vector<String>();
            long vectorInsertStart = System.nanoTime();
            for (int i = 0; i < arr.length; i++) {
                vector.add(arr[i]);
            }
            long vectorInsertStop = System.nanoTime();
            vectorInsertSum += vectorInsertStop - vectorInsertStart;

            long vectorGetByIndexStart = System.nanoTime();
            String s1 = "";
            for (int i = 0; i < arr.length; i++) {
                s1 = vector.get(i);
            }
            long vectorGetByIndexStop = System.nanoTime();
            vectorGetByIndexSum += vectorGetByIndexStop - vectorGetByIndexStart;

            long vectorGetByIterStart = System.nanoTime();
            String s2 = "";
            for (String s : vector) {
                s2 = s;
            }
            long vectorGetByIterStop = System.nanoTime();
            vectorGetByIterSum += vectorGetByIterStop - vectorGetByIterStart;
        }

        LinkedHashMap<String, Long> results = new LinkedHashMap<String, Long>();

        results.put("ArrayList inserting",(arrayListInsertSum / this.getRuns()));
        results.put("LinkedList inserting",(linkedListInsertSum / this.getRuns()));
        results.put("Vector inserting",(vectorInsertSum / this.getRuns()));

        results.put("ArrayList getting by index",(arrayListGetByIndexSum / this.getRuns()));
        results.put("LinkedList getting by index",(linkedListGetByIndexSum / this.getRuns()));
        results.put("Vector getting by index",(vectorGetByIndexSum / this.getRuns()));

        results.put("ArrayList getting by iterator",(arrayListGetByIterSum / this.getRuns()));
        results.put("LinkedList getting by iterator",(linkedListGetByIterSum / this.getRuns()));
        results.put("Vector getting by iterator",(vectorGetByIterSum / this.getRuns()));

        return results;

    }
}
