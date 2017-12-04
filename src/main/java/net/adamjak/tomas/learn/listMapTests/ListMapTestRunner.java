package net.adamjak.tomas.learn.listMapTests;

import net.adamjak.tomas.learn.TestLearnException;

import java.util.Map;

public class ListMapTestRunner {

    private ListMapTest listMapTest;


    public enum RunType {
        LIST(ListTestRunner.class),
        MAP(MapTestRunner.class);
        private Class<? extends ListMapTest> clazz;

        RunType(Class<? extends ListMapTest> clazz) {
            this.clazz = clazz;
        }

        public Class<? extends ListMapTest> getClazz() {
            return clazz;
        }
    }

    private ListMapTestRunner(ListMapTest listMapTest) {
        this.listMapTest = listMapTest;
    }

    public static ListMapTestRunner create (RunType runType, int runs, int values) throws TestLearnException {
        ListMapTest listMapTest;

        try {
            listMapTest = runType.getClazz().newInstance();
        } catch (Exception e) {
            throw new TestLearnException("Create ListMapTest error", e);
        }

        listMapTest.init(runs, values);

        return new ListMapTestRunner(listMapTest);
    }

    public void run () {
        Map<String, Long> results = this.listMapTest.run();

        System.out.println("Results:");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Runs:   " + this.listMapTest.getRuns());
        System.out.println("Values: " + this.listMapTest.getValues());
        System.out.println("Class:  " + this.listMapTest.getClass().getSimpleName());
        System.out.println("--------------------------------------------------------------------------------");

        for (String key : results.keySet()) {
            System.out.println(key + ": " + results.get(key));
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

}
