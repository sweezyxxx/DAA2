package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    private final PerformanceTracker tracker = new PerformanceTracker();

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        tracker.start();

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                tracker.incrementComparisons();
                continue;
            }

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                tracker.incrementComparisons();
                arr[j + 1] = arr[j];
                tracker.incrementSwaps();
                j--;
            }

            if (j >= 0) tracker.incrementComparisons();

            arr[j + 1] = key;
        }

        tracker.stop();
    }

    public PerformanceTracker getTracker() {
        return tracker;
    }
}
