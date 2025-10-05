package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {

    private static int[] generateArray(int n, String type) {
        Random rand = new Random();
        int[] arr = new int[n];

        switch (type.toLowerCase()) {
            case "sorted":
                for (int i = 0; i < n; i++) arr[i] = i;
                break;
            case "reversed":
                for (int i = 0; i < n; i++) arr[i] = n - i;
                break;
            case "nearlysorted":
                for (int i = 0; i < n; i++) arr[i] = i;
                for (int i = 0; i < n / 10; i++) {
                    int a = rand.nextInt(n);
                    int b = rand.nextInt(n);
                    int temp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp;
                }
                break;
            default: // random
                for (int i = 0; i < n; i++) arr[i] = rand.nextInt(10_000);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000};
        String[] types = {"random", "sorted", "reversed", "nearlysorted"};

        for (String type : types) {
            System.out.println("\n=== " + type.toUpperCase() + " INPUT ===");
            for (int n : sizes) {
                int[] arr = generateArray(n, type);

                InsertionSort sorter = new InsertionSort();
                PerformanceTracker tracker = sorter.getTracker();

                tracker.reset();
                tracker.start();
                sorter.sort(Arrays.copyOf(arr, arr.length));
                tracker.stop();

                System.out.printf("n = %-6d → %s%n", n, tracker.toString());
            }
        }
    }
}
