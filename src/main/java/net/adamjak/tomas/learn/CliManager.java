package net.adamjak.tomas.learn;

import net.adamjak.tomas.learn.listMapTests.ListMapTest;
import net.adamjak.tomas.learn.listMapTests.ListMapTestRunner;
import net.adamjak.tomas.learn.listMapTests.ListTestRunner;
import net.adamjak.tomas.learn.listMapTests.MapTestRunner;
import org.apache.commons.cli.*;

public class CliManager {

    private static String[] arguments = null;

    public static void manage (String args[]) {
        CliManager.arguments = args;

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try
        {
            cmd = parser.parse(CliManager.getOptions(), arguments);
        }
        catch (ParseException e)
        {
            CliManager.printError("Error in parse cli arguments!\n" + "Message: " + e.getMessage());
            System.exit(-1);
        }

        if (cmd.hasOption("author"))
        {
            System.out.println("Tomas Adamjak");
        }
        else if (cmd.hasOption("license"))
        {
            System.out.println("BSD 3-line");
        }
        else if ((cmd.hasOption("l") || cmd.hasOption("m")) && cmd.hasOption("r") && cmd.hasOption("nv"))
        {

            int runs = 0, values = 0;
            ListMapTestRunner.RunType runType = cmd.hasOption('l') ? ListMapTestRunner.RunType.LIST : ListMapTestRunner.RunType.MAP;

            try {
                runs = Integer.valueOf(cmd.getOptionValue("r")).intValue();
                values = Integer.valueOf(cmd.getOptionValue("nv")).intValue();
            } catch (NumberFormatException e) {
                CliManager.printError(e.getMessage());
                System.exit(-1);
            }

            try {
                ListMapTestRunner.create(runType, runs, values).run();
            } catch (TestLearnException e) {
                CliManager.printError(e.getMessage());
                System.exit(-1);
            }
        }
        else
        {
            CliManager.printHelp();
        }
    }

    public static String[] getArguments ()
    {
        return arguments;
    }

    private static Options getOptions ()
    {
        Options options = new Options();
        options.addOption("author", false, "print informations about author");
        options.addOption("license", false, "print license informations");
        options.addOption("l","list-comparation", false, "ArrayList, LinkedList and Vector comparation");
        options.addOption("m","map-comparation", false, "HashMap, Hashtable, TreeMap and WeakHashMap comparation");
        options.addOption("r", "runs", true, "number of runs loop");
        options.addOption("nv", "number-of-values", true, "number of values");

        return options;
    }

    public static void printHelp ()
    {
        String example = "\nExample: java -jar app.jar -l -r 100 -nv 1000\n\n";

        HelpFormatter formatter = new HelpFormatter();
        formatter.setWidth(90);
        formatter.printHelp("java -jar /path/to/application.jar [OPTIONS...]", example, CliManager.getOptions(), "");
    }

    public static void printError (String err)
    {
        int borderSize = 0;

        if (err.contains("\n"))
        {
            for (String s : err.split("\n"))
            {
                if (s.length() > borderSize) borderSize = s.length();
            }
        }

        for (int i = 0; i < borderSize; i++)
        {
            System.err.print("!");
        }
        System.err.println("");

        System.err.println(err);

        for (int i = 0; i < borderSize; i++)
        {
            System.err.print("!");
        }

        System.out.println("");
    }
}
