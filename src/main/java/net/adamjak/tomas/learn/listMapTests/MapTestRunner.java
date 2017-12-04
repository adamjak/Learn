package net.adamjak.tomas.learn.listMapTests;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.WeakHashMap;

public class MapTestRunner extends ListMapTest {


    @Override
    LinkedHashMap<String, Long> run() {
        String[] keyArr = new String[this.getValues()];
        String[] valArr = new String[this.getValues()];
        for (int i = 0; i < this.getValues(); i++) {
            keyArr[i] = UUID.randomUUID().toString();
            valArr[i] = UUID.randomUUID().toString();
        }


        long hashMapInserting = 0;
        long hashtableInserting = 0;
        long treeMapInserting = 0;
        long weakHashMapInserting = 0;

        long hashMapGetting = 0;
        long hashtableGetting = 0;
        long treeMapGetting = 0;
        long weakHashMapGetting = 0;

        for (int r = 0; r < this.getRuns(); r++) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            Hashtable<String, String> hashtable = new Hashtable<String, String>();
            TreeMap<String, String> treeMap = new TreeMap<String, String>();
            WeakHashMap<String, String> weakHashMap = new WeakHashMap<String, String>();

            // inserting
            //======================================================
            long hmis = System.nanoTime();
            for (int i = 0; i < this.getValues(); i++) {
                hashMap.put(keyArr[i], valArr[i]);
            }
            long hmie = System.nanoTime();
            hashMapInserting += hmie - hmis;

            long htis = System.nanoTime();
            for (int i = 0; i < this.getValues(); i++) {
                hashtable.put(keyArr[i], valArr[i]);
            }
            long htie = System.nanoTime();
            hashtableInserting += htie - htis;

            long tmis = System.nanoTime();
            for (int i = 0; i < this.getValues(); i++) {
                treeMap.put(keyArr[i], valArr[i]);
            }
            long tmie = System.nanoTime();
            treeMapInserting += tmie - tmis;

            long whmis = System.nanoTime();
            for (int i = 0; i < this.getValues(); i++) {
                weakHashMap.put(keyArr[i], valArr[i]);
            }
            long whmie = System.nanoTime();
            weakHashMapInserting += whmie - whmis;

            // getting
            //======================================================
            String val = "";
            long hmgs = System.nanoTime();
            for (String key : hashMap.keySet()) {
                val = hashMap.get(key);
            }
            long hmge = System.nanoTime();
            hashMapGetting += hmge - hmgs;

            long htgs = System.nanoTime();
            for (String key : hashtable.keySet()) {
                val = hashtable.get(key);
            }
            long htge = System.nanoTime();
            hashtableGetting += htge - htgs;

            long tmgs = System.nanoTime();
            for (String key : treeMap.keySet()) {
                val = treeMap.get(key);
            }
            long tmge = System.nanoTime();
            treeMapGetting += tmge - tmgs;

            long whmgs = System.nanoTime();
            for (String key : weakHashMap.keySet()) {
                val = weakHashMap.get(key);
            }
            long whmge = System.nanoTime();
            weakHashMapGetting += whmge - whmgs;
        }

        LinkedHashMap<String, Long> results = new LinkedHashMap<String, Long>();

        results.put("HashMap inserting",(hashMapInserting / this.getRuns()));
        results.put("Hashtable inserting",(hashtableInserting / this.getRuns()));
        results.put("TreeMap inserting",(treeMapInserting / this.getRuns()));
        results.put("WeakHashMap inserting",(weakHashMapInserting / this.getRuns()));

        results.put("HashMap getting",(hashMapGetting / this.getRuns()));
        results.put("Hashtable getting",(hashtableGetting / this.getRuns()));
        results.put("TreeMap getting",(treeMapGetting / this.getRuns()));
        results.put("WeakHashMap getting",(weakHashMapGetting / this.getRuns()));

        return results;
    }
}
