package src;

import org.jetbrains.annotations.NotNull;

public class AverageFinder {
    public static void main(String[] args) {
        System.out.println("Average finder v0.1");
        double avg = findAverage(args);
        System.out.println("The average is " + avg);
    }

    private static double findAverage(String @NotNull [] input) {
        double result = 0;
        for (String s : input) {
            result += Integer.parseInt(s);
        }
        return result/ input.length;
    }
}
