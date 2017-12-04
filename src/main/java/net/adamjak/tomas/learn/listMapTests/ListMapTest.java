package net.adamjak.tomas.learn.listMapTests;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ListMapTest {
    private int runs;
    private int values;

    void init (int runs, int values) {
        this.runs = runs;
        this.values = values;
    }

    public int getRuns() {
        return runs;
    }

    public int getValues() {
        return values;
    }

    abstract LinkedHashMap<String, Long> run();
}
